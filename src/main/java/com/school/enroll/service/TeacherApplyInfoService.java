package com.school.enroll.service;

import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.vo.TeacherInfoVo;

import java.util.List;

public interface TeacherApplyInfoService {

    List<TeacherApplyInfo> getTeacherApplyInfo(TeacherInfoVo teacherInfoVo);


    List<TeacherApplyInfo> updateStudentStatus();

    int updateTeacherStatus(Long id, String status);

    List<TeacherApplyDetailResult> getTeacherApplyInfoDetail(Long id);
}
