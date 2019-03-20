package com.school.enroll.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.school.enroll.service.WxService;
import com.school.enroll.util.HttpClientUtil;
import com.school.enroll.vo.HttpClientResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * WxServiceImpl
 *
 * @author houxin
 * @date 2019/3/20
 */
@Slf4j
@Service
public class WxServiceImpl implements WxService {

    @Value("${wx.appid}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;

    @Override
    public String getOpenId(String code) {
        String openId;
        String getOpenIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> paramMap = new HashMap<>(16);
        paramMap.put("appid", appId);
        paramMap.put("secret", secret);
        paramMap.put("code", code);
        paramMap.put("grant_type", "authorization_code");
        try {
            HttpClientResult httpClientResult = HttpClientUtil.doGet(getOpenIdUrl, null, paramMap);
            log.info("httpClientResult = {}", httpClientResult);
            String resultContent = httpClientResult.getContent();
            JSONObject resultJsonObject = JSON.parseObject(resultContent);
            openId = resultJsonObject.getString("openid");
            return openId;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
