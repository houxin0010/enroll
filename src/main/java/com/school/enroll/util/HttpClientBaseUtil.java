package com.school.enroll.util;

import com.alibaba.fastjson.JSON;
import com.school.enroll.vo.HttpClientResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * HttpClientBaseUtil
 *
 * @author houxin
 * @date 2019/3/20
 */
@Slf4j
public class HttpClientBaseUtil {
    // 编码格式。发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";

    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 12000;

    // 请求获取数据的超时时间(即响应时间)，单位毫秒。
    private static final int SOCKET_TIMEOUT = 12000;

    /**
     * GET请求
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param params  请求参数
     * @param proxy   请求代理
     * @return
     * @throws Exception
     */
    public static HttpClientResult httpClientGet(String url, Map<String, String> headers, Map<String, String> params, HttpHost proxy) throws Exception {

        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建访问的地址
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
        }
        log.info("httpClientGet URL = {}", uriBuilder.toString());

        // 创建http对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        httpGet.setConfig(requestConfig);

        // 设置请求头
        packageHeader(headers, httpGet);


        // 创建httpResponse对象
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        try {
            // 执行请求并获得响应结果
            return getHttpClientResult(httpResponse);
        } finally {
            // 释放资源
            release(httpGet, httpResponse, httpClient);
        }
    }

    /**
     * POST请求
     *
     * @param url     请求地址
     * @param headers 请求头
     * @param params  请求参数
     * @param proxy   请求代理
     * @return
     * @throws Exception
     */
    public static HttpClientResult httpClientPost(String url, Map<String, String> headers, Map<String, String> params, HttpHost proxy) throws Exception {
        log.info("httpClientPost URL = {}", url);

        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建http对象
        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(proxy)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();

        httpPost.setConfig(requestConfig);

        // 封装请求头
        packageHeader(headers, httpPost);
        // 封装请求参数
        final String contentTypeHeader = Optional.ofNullable(headers).map(headersMap -> headersMap.get("Content-Type")).orElse("");
        if (!StringUtils.isEmpty(contentTypeHeader)) {
            if (contentTypeHeader.contains(MediaType.APPLICATION_JSON_VALUE)) {
                StringEntity strEntity = new StringEntity(JSON.toJSONString(params), ENCODING);
                strEntity.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                log.info("json 请求参数 = {}", JSON.toJSONString(params));
                httpPost.setEntity(strEntity);
            } else {
                packageParam(params, httpPost);
            }
        } else {
            packageParam(params, httpPost);
        }

        // 执行http请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try {
            // 获得响应结果
            return getHttpClientResult(httpResponse);
        } finally {
            // 释放资源
            release(httpPost, httpResponse, httpClient);
        }
    }

    /**
     * Description: 封装请求头
     *
     * @param params
     * @param httpMethod
     */
    private static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 封装请求参数
     *
     * @param params
     * @param httpMethod
     * @throws Exception
     */
    private static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod) throws Exception {
        log.info("请求参数 = {}", JSON.toJSONString(params));
        // 封装请求参数
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<>();
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

    /**
     * Description: 获得响应结果
     *
     * @param httpResponse
     * @return
     * @throws Exception
     */
    private static HttpClientResult getHttpClientResult(CloseableHttpResponse httpResponse) throws Exception {
        // 获取返回结果
        if (httpResponse != null && httpResponse.getStatusLine() != null) {
            String content = "";
            if (httpResponse.getEntity() != null) {
                content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
            }
            return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
        }
        return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 释放资源
     *
     * @param httpRequestBase
     * @param httpClient
     * @throws IOException
     */
    private static void release(HttpRequestBase httpRequestBase, CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
        // 释放资源
        if (httpRequestBase != null) {
            httpRequestBase.releaseConnection();
        }
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }
}
