package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.MiddleSchoolApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/middleSchool")
public class MiddleSchoolEnrollController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/index")
    public String index(Model model) {
        String openId = "wx_test";
        List<StudentInfo> studentInfoList = studentInfoService.getStudentInfoByOpenId(openId, 0);
        model.addAttribute("studentInfoList", studentInfoList);
        return "wechat/middleEnrollList";
    }

    @RequestMapping("/enroll")
    public String enroll() {
        return "wechat/middleEnroll";
    }

    @RequestMapping("/apply")
    public ResponseEntity apply(@RequestBody MiddleSchoolApplyVo middleSchoolApplyVo) {
        String openId = "wx_test";
        studentInfoService.createMiddleStudentInfo(middleSchoolApplyVo, openId);
        return ResponseEntity.ok("保存成功!");
    }

    @GetMapping("/studentEnrollDetail")
    public String studentEnrollDetail(Long id, Model model) {
        FullEnrollStudentInfo fullEnrollStudentInfo = studentInfoService.getFullEnrollStudentInfo(id);
        model.addAttribute("fullEnrollStudentInfo", fullEnrollStudentInfo);
        return "wechat/middleEnrollDetail";
    }
}
