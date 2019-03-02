package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.StudentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/backstage")
public class BackstageController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/primary/index")
    public String primarySchoolIndex(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> primaryStudentInfoList = studentInfoService.getPrimaryStudentInfo(studentInfoVo);
        model.addAttribute("primaryStudentInfoList", primaryStudentInfoList);
        return "backstage/primarySchool";
    }

    @RequestMapping("/primary/getPrimaryStudentInfo")
    public String getStudentInfo(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> primaryStudentInfoList = studentInfoService.getPrimaryStudentInfo(studentInfoVo);
        model.addAttribute("primaryStudentInfoList", primaryStudentInfoList);
        return "backstage/primarySchool::primaryStudentInfoList";
    }

    @RequestMapping("/middle/index")
    public String middleSchoolIndex(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> primaryStudentInfoList = studentInfoService.getMiddleStudentInfo(studentInfoVo);
        model.addAttribute("middleStudentInfoList", primaryStudentInfoList);
        return "backstage/middleSchool";
    }

    @RequestMapping("/middle/getMiddleStudentInfo")
    public String getMiddleStudentInfo(StudentInfoVo studentInfoVo, Model model) {
        List<StudentInfo> middleStudentInfoList = studentInfoService.getMiddleStudentInfo(studentInfoVo);
        model.addAttribute("middleStudentInfoList", middleStudentInfoList);
        return "backstage/MiddleSchool::middleStudentInfoList";
    }

    @RequestMapping("/updateStatus")
    public ResponseEntity updateStudentStatus(Long id, String status) {
        return ResponseEntity.ok(studentInfoService.updateStudentStatus(id, status));
    }
}
