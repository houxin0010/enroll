package com.school.enroll.service.impl;

import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.mapper.TeacherApplyInfoMapper;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.service.TeacherApplyInfoService;
import com.school.enroll.vo.TeacherInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherApplyInfoServiceImpl implements TeacherApplyInfoService {

    @Autowired
    private TeacherApplyInfoMapper teacherApplyInfoMapper;


    @Override
    public List<TeacherApplyInfo> getTeacherApplyInfo(TeacherInfoVo teacherInfoVo) {
        List<TeacherApplyInfo> list = teacherApplyInfoMapper.findTeacherByParams(teacherInfoVo);
        return list;
    }

    @Override
    public List<TeacherApplyInfo> updateStudentStatus() {
        return null;
    }

    @Override
    public int updateTeacherStatus(Long id, String status) {
        TeacherApplyInfo teacherApplyInfo = new TeacherApplyInfo();
        teacherApplyInfo.setId(id);
        teacherApplyInfo.setStatus(status);
        int count = teacherApplyInfoMapper.updateById(teacherApplyInfo);
        return count;
    }

    @Override
    public List<TeacherApplyDetailResult> getTeacherApplyInfoDetail(Long id) {
        return null;
    }
}
