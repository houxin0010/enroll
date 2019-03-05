package com.school.enroll.service;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.result.StudentInfoDetailResult;
import com.school.enroll.vo.PrimaryStudentInfoVo;
import com.school.enroll.vo.StudentInfoVo;

import java.util.List;

public interface StudentInfoService {

    List<StudentInfo> getPrimaryStudentInfo(StudentInfoVo studentInfoVo);

    List<StudentInfo> getMiddleStudentInfo(StudentInfoVo studentInfoVo);

    int updateStudentStatus(Long id, String status);

    void createStudentInfo(PrimaryStudentInfoVo primaryStudentInfoVo);

    StudentInfoDetailResult getStudentInfoDetail(Long id);
}
