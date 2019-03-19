package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/primarySchool")
public class PrimarySchoolEnrollController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/getAuthCode")
    public String getAuthCode() {
        String appid = "wx1ffbee7b7b2f5409";
        String redirectUri = "";
        try {
            redirectUri = URLEncoder.encode("http://enroll.natapp1.cc/primarySchool/index", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        String responseType = "code";
        String scope = "snsapi_base";
        String state = "primary";
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid +
                "&redirect_uri=" + redirectUri +
                "&response_type=" + responseType +
                "&scope=" + scope +
                "&state=" + state + "#wechat_redirect";
    }

    @RequestMapping("/index")
    public String index(String code, String state, Model model) {
        if (!"primary".equals(state)) {
            return "";
        }
        String openId = "wx_test";
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
}
