package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.service.WxService;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.MiddleSchoolApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/middleSchool")
public class MiddleSchoolEnrollController {

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
            openId = "middle-" + openId;
            session.setAttribute(session.getId(), openId);
        }
        List<StudentInfo> studentInfoList = studentInfoService.getStudentInfoByOpenId(openId, 1);
        model.addAttribute("studentInfoList", studentInfoList);
        return "wechat/middleEnrollList";
    }

    @RequestMapping("/enroll")
    public String enroll() {
        return "wechat/middleEnroll";
    }

    @RequestMapping("/apply")
    public String apply(@RequestBody MiddleSchoolApplyVo middleSchoolApplyVo) {
        HttpSession session = request.getSession();
        String openId = (String) session.getAttribute(session.getId());
        if (StringUtils.isEmpty(openId)) {
            return "wechat/wxError";
        }
        studentInfoService.createMiddleStudentInfo(middleSchoolApplyVo, openId);
        return "wechat/middleEnrollSuccess";
    }

    @GetMapping("/studentEnrollDetail")
    public String studentEnrollDetail(Long id, Model model) {
        FullEnrollStudentInfo fullEnrollStudentInfo = studentInfoService.getFullEnrollStudentInfo(id);
        model.addAttribute("fullEnrollStudentInfo", fullEnrollStudentInfo);
        return "wechat/middleEnrollDetail";
    }

    @RequestMapping("/applySuccess")
    public String applySuccess() {
        return "wechat/MiddleEnrollSuccess";
    }
}
