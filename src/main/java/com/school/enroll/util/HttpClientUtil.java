package com.school.enroll.util;

import com.school.enroll.vo.HttpClientResult;
import org.apache.http.HttpHost;

import java.util.Map;

import static com.school.enroll.util.HttpClientBaseUtil.httpClientGet;
import static com.school.enroll.util.HttpClientBaseUtil.httpClientPost;

/**
 * HttpClientUtil
 *
 * @author houxin
 * @date 2019/3/20
 */
public class HttpClientUtil {
    
    public static HttpClientResult doGet(String url) throws Exception {
        return httpClientGet(url, null, null, null);
    }

    public static HttpClientResult doGet(String url, Map<String, String> headers) throws Exception {
        return httpClientGet(url, headers, null, null);
    }

    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        return httpClientGet(url, headers, params, null);
    }

    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params, String proxyHost, int proxyPort) throws Exception {
        return httpClientGet(url, headers, params, new HttpHost(proxyHost, proxyPort));
    }

    public static HttpClientResult doPost(String url) throws Exception {
        return httpClientPost(url, null, null, null);
    }

    public static HttpClientResult doPost(String url, Map<String, String> headers) throws Exception {
        return httpClientPost(url, headers, null, null);
    }

    public static HttpClientResult doPost(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        return httpClientPost(url, headers, params, null);
    }

    public static HttpClientResult doPost(String url, Map<String, String> headers, Map<String, String> params, String proxyHost, int proxyPort) throws Exception {
        return httpClientPost(url, headers, params, new HttpHost(proxyHost, proxyPort));
    }
}
