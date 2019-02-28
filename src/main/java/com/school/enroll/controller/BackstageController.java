package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.StudentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/backstage")
public class BackstageController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/index")
    public String index(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> studentInfos = studentInfoService.getStudentInfo(studentInfoVo);
        model.addAttribute("studentInfos", studentInfos);
        return "backstage/primarySchool";
    }

    @RequestMapping("/getStudentInfo")
    public String getStudentInfo(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> studentInfos = studentInfoService.getStudentInfo(studentInfoVo);
        model.addAttribute("studentInfos", studentInfos);
        return "backstage/primarySchool::table_refresh";
    }
}
