package com.school.enroll.controller;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.result.StudentInfoDetailResult;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.service.TeacherApplyInfoService;
import com.school.enroll.vo.StudentInfoVo;
import com.school.enroll.vo.TeacherInfoQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/backstage")
@Slf4j
public class BackstageController {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TeacherApplyInfoService teacherApplyInfoService;

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

    @RequestMapping("/teacher/index")
    public String teacherSchoolIndex(TeacherInfoQueryVo teacherInfoQueryVo, Model model){
        List<TeacherApplyInfo> teacherApplyInfoList = teacherApplyInfoService.getTeacherApplyInfo(teacherInfoQueryVo);
        model.addAttribute("teacherApplyInfoList",teacherApplyInfoList);
        return"backstage/teacherApply";
    }
    @RequestMapping("/teacher/getTeacherApplyInfo")
    public String getTeacherApplyInfo(TeacherInfoQueryVo teacherInfoQueryVo, Model model){
        List<TeacherApplyInfo> teacherApplyInfoList = teacherApplyInfoService.getTeacherApplyInfo(teacherInfoQueryVo);
        model.addAttribute("teacherApplyInfoList",teacherApplyInfoList);
        return"backstage/teacherApply::teacherApplyInfoList";
    }
    @RequestMapping("/updateTeacherStatus")
    public ResponseEntity updateTeacherStatus(Long id, String status) {
        return ResponseEntity.ok(teacherApplyInfoService.updateTeacherStatus(id, status));

    }
    @RequestMapping("/teacher/detail")
    public String teacherDetail(Long id,Model model){
        TeacherApplyDetailResult teacherApplyDetailResult = teacherApplyInfoService.getTeacherApplyInfoDetail(id);
        model.addAttribute("teacherApplyDetailResult", teacherApplyDetailResult);
        return "backstage/teacherApply::teacherApplyDetailResult";
    }
    @RequestMapping("/middle/student/detail")
    public String middleStudentDetail(Long id,Model model){
        StudentInfoDetailResult studentInfoDetailResult = studentInfoService.getStudentInfoDetail(id);
        model.addAttribute("studentInfoDetailResult",studentInfoDetailResult);
        return "backstage/middleSchool::studentInfoDetailResult";
    }
    @RequestMapping("/primary/student/detail")
    public String primaryStudentDetail(Long id,Model model){
        StudentInfoDetailResult studentInfoDetailResult = studentInfoService.getStudentInfoDetail(id);
        model.addAttribute("studentInfoDetailResult",studentInfoDetailResult);
        return "backstage/primarySchool::studentInfoDetailResult";
    }
}
