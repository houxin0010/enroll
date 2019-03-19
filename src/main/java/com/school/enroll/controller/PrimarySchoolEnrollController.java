package com.school.enroll.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.util.HttpClientUtil;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.HttpClientResult;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/primarySchool")
public class PrimarySchoolEnrollController {

    @Value("${wx.appid}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/index")
    public String index(String code, String state, Model model) {
        if (!"primary".equals(state)) {
            return "wechat/wxError";
        }
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
            if (!httpClientResult.isOk()) {
                return "wechat/wxError";
            }
            String resultContent = httpClientResult.getContent();
            JSONObject resultJsonObject = JSON.parseObject(resultContent);
            openId = resultJsonObject.getString("openid");
            if (StringUtils.isEmpty(openId)) {
                return "wechat/wxError";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "wechat/wxError";
        }
        List<StudentInfo> studentInfoList = studentInfoService.getStudentInfoByOpenId(openId, 0);
        model.addAttribute("studentInfoList", studentInfoList);
        return "wechat/primaryEnrollList";
    }

    @RequestMapping("/enroll")
    public String enroll() {
        return "wechat/primaryEnroll";
    }

    @RequestMapping("/apply")
    public ResponseEntity apply(@RequestBody PrimarySchoolApplyVo primarySchoolApplyVo) {
        String openId = "wx_test";
        studentInfoService.createPrimaryStudentInfo(primarySchoolApplyVo, openId);
        return ResponseEntity.ok("success!");
    }

    @GetMapping("/studentEnrollDetail")
    public String studentEnrollDetail(Long id, Model model) {
        FullEnrollStudentInfo fullEnrollStudentInfo = studentInfoService.getFullEnrollStudentInfo(id);
        model.addAttribute("fullEnrollStudentInfo", fullEnrollStudentInfo);
        return "wechat/primaryEnrollDetail";
    }

    @RequestMapping("/applySuccess")
    public String applySuccess() {
        return "wechat/primaryEnrollSuccess";
    }

    public static void main(String[] args) {
        String redirectUri = "";
        try {
            redirectUri = URLEncoder.encode("http://enroll.natapp1.cc/primarySchool/index", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        System.out.println(redirectUri);
    }
}
