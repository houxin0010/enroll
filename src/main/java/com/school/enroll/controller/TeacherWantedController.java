package com.school.enroll.controller;

import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.service.TeacherApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacherWanted")
public class TeacherWantedController {

    @Autowired
    private TeacherApplyInfoService teacherApplyInfoService;

    @RequestMapping("/index")
    public String index(Model model){
        String openId = "wx_test";
        List<TeacherApplyInfo> teacherApplyInfoList = teacherApplyInfoService.getTeacherApplyInfoByOpenId(openId);
        model.addAttribute("teacherApplyInfoList", teacherApplyInfoList);
        return "wechat/teacherWantedList";
    }

}
