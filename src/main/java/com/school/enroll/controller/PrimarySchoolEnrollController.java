package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/primarySchool")
public class PrimarySchoolEnrollController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/index")
    public String index(Model model) {
        String openId = "wx_test";
        List<StudentInfo> studentInfoList = studentInfoService.getStudentInfoByOpenId(openId, 0);
        model.addAttribute("studentInfoList", studentInfoList);
        return "wechat/primaryEnrollList";
    }

    @RequestMapping("/enroll")
    public String enroll() {
        return "wechat/primaryEnroll";
    }

    @RequestMapping("/primarySchoolApply")
    public ResponseEntity primarySchoolApply(@RequestBody PrimarySchoolApplyVo primarySchoolApplyVo) {
        String openId = "wx_test";
        studentInfoService.createStudentInfo(primarySchoolApplyVo, openId);
        return ResponseEntity.ok("保存成功!");
    }

    @GetMapping("/studentEnrollDetail")
    public String studentEnrollDetail(Long id, Model model) {
        FullEnrollStudentInfo fullEnrollStudentInfo = studentInfoService.getFullEnrollStudentInfo(id);
        model.addAttribute("fullEnrollStudentInfo", fullEnrollStudentInfo);
        return "wechat/primaryEnrollDetail";
    }
}
