package com.school.enroll.service;

import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.vo.TeacherInfoVo;

import java.util.List;

public interface TeacherApplyInfoService {

    List<TeacherApplyInfo> getTeacherApplyInfo(TeacherInfoVo teacherInfoVo);

    List<TeacherApplyInfo> getTeacherApplyInfoByOpenId(String openId);

    int updateTeacherStatus(Long id, String status);

    TeacherApplyDetailResult getTeacherApplyInfoDetail(Long id);
}
