package com.school.enroll.controller;

import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/primarySchool")
public class PrimarySchoolEnrollController {

    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("/index")
    public String index() {
        return "/wechat/primaryEnroll";
    }

    @RequestMapping("/primarySchoolApply")
    public ResponseEntity primarySchoolApply(@RequestBody PrimarySchoolApplyVo primarySchoolApplyVo) {
        studentInfoService.createStudentInfo(primarySchoolApplyVo.getPrimaryStudentInfoVo());

        return ResponseEntity.ok("保存成功!");
    }
}
