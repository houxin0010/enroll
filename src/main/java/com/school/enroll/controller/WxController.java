package com.school.enroll.controller;

import com.school.enroll.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/wechat")
public class WxController {

    @GetMapping("/checkUrl")
    public String checkUrl(String signature, String timestamp, String nonce, String echostr) {
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }
}
