package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.service.WxService;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/primarySchool")
public class PrimarySchoolEnrollController {

    @Value("${wx.appid}")
    private String appId;
    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private WxService wxService;

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/index")
    public String index(String code, String state, Model model) {
        HttpSession session = request.getSession();
        String openId = (String) session.getAttribute(session.getId());
        if (StringUtils.isEmpty(openId)) {
            openId = wxService.getOpenId(code);
            if (StringUtils.isEmpty(openId)) {
                return "wechat/wxError";
            }
            openId = "primary-" + openId;
            session.setAttribute(session.getId(), openId);
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
    public String apply(@RequestBody PrimarySchoolApplyVo primarySchoolApplyVo) {
        HttpSession session = request.getSession();
        String openId = (String) session.getAttribute(session.getId());
        if (StringUtils.isEmpty(openId)) {
            return "wechat/wxError";
        }
        studentInfoService.createPrimaryStudentInfo(primarySchoolApplyVo, openId);
        return "wechat/primaryEnrollSuccess";
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
            redirectUri = URLEncoder.encode("http://enroll.natapp1.cc/primarySchool/apply", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        System.out.println(redirectUri);
    }
}
