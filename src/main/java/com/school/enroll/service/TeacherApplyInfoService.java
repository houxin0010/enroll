package com.school.enroll.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.vo.TeacherInfoQueryVo;
import com.school.enroll.vo.TeacherWantedInfoVo;

import java.util.List;

public interface TeacherApplyInfoService {

    IPage<TeacherApplyInfo> getTeacherApplyInfo(Page<StudentInfo> page, TeacherInfoQueryVo teacherInfoQueryVo);

    List<TeacherApplyInfo> getTeacherApplyInfoByOpenId(String openId);

    int updateTeacherStatus(Long id, String status);

    TeacherApplyDetailResult getTeacherApplyInfoDetail(Long id);

    void createTeacherInfo(TeacherWantedInfoVo teacherWantedInfoVo, String openId);

    int deletc(Long id);
}
