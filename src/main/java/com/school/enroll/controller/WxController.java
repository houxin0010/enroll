package com.school.enroll.controller;

import com.school.enroll.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@Controller
@RequestMapping("/wechat")
public class WxController {

    @Value("${wx.appid}")
    private String appId;

    @GetMapping("/checkUrl")
    public ResponseEntity<String> checkUrl(String signature, String timestamp, String nonce, String echostr) {
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return ResponseEntity.ok(echostr);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getAuthCode")
    public String getAuthCode(String redirectUri) {
        String responseType = "code";
        String scope = "snsapi_base";
        String state = "primary";
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId +
                "&redirect_uri=" + redirectUri +
                "&response_type=" + responseType +
                "&scope=" + scope +
                "&state=" + state + "#wechat_redirect";
    }

    @GetMapping("/getAuthCodeCallBack")
    public ResponseEntity<String> getAuthCodeCallBack(String code, String state) {
        if ("enroll".equals(state)) {
            return ResponseEntity.ok(code);
        }
        return ResponseEntity.ok(null);
    }
}
