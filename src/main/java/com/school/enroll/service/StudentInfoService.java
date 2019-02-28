package com.school.enroll.service;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.vo.StudentInfoVo;

import java.util.List;

public interface StudentInfoService {

    List<StudentInfo> getStudentInfo(StudentInfoVo studentInfoVo);
}
