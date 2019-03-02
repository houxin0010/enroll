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
        List<StudentInfo> primaryStudentInfoList = studentInfoService.getPrimaryStudentInfo(studentInfoVo);
        model.addAttribute("primaryStudentInfoList", primaryStudentInfoList);
        return "backstage/primarySchool";
    }

    @RequestMapping("/getPrimaryStudentInfo")
    public String getStudentInfo(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> primaryStudentInfoList = studentInfoService.getPrimaryStudentInfo(studentInfoVo);
        model.addAttribute("primaryStudentInfoList", primaryStudentInfoList);
        return "backstage/primarySchool::primaryStudentInfoList";
    }

    @RequestMapping("/getMiddleStudentInfo")
    public String getMiddleStudentInfo(StudentInfoVo studentInfoVo, Model model){
        List<StudentInfo> middleStudentInfoList = studentInfoService.getMiddleStudentInfo(studentInfoVo);
        model.addAttribute("middleStudentInfoList", middleStudentInfoList);
        return "backstage/MiddleSchool::middleStudentInfoList";
    }
}
