package com.school.enroll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.school.enroll.entity.*;
import com.school.enroll.mapper.*;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.service.TeacherApplyInfoService;
import com.school.enroll.vo.TeacherInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherApplyInfoServiceImpl implements TeacherApplyInfoService {

    @Autowired
    private TeacherApplyInfoMapper teacherApplyInfoMapper;
    @Autowired
    private JobExperienceMapper jobExperienceMapper;
    @Autowired
    private WorkExperienceMapper workExperienceMapper;
    @Autowired
    private TrainingExperienceMapper trainingExperienceMapper;
    @Autowired
    private EducationExperienceMapper educationExperienceMapper;

    @Override
    public List<TeacherApplyInfo> getTeacherApplyInfo(TeacherInfoVo teacherInfoVo) {
        return teacherApplyInfoMapper.findTeacherByParams(teacherInfoVo);
    }

    @Override
    public List<TeacherApplyInfo> getTeacherApplyInfoByOpenId(String openId) {
        return teacherApplyInfoMapper.selectList(new LambdaQueryWrapper<TeacherApplyInfo>().eq(TeacherApplyInfo::getOpenId, openId));
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
    public TeacherApplyDetailResult getTeacherApplyInfoDetail(Long id) {
        TeacherApplyDetailResult teacherApplyDetailResult = new TeacherApplyDetailResult();
        TeacherApplyInfo teacherApplyInfo = teacherApplyInfoMapper.selectById(id);
        List<JobExperience> jobExperiences = jobExperienceMapper.selectListByTeacherId(id);
        List<WorkExperience> workExperiences = workExperienceMapper.selectListByTeacherId(id);
        List<TrainingExperience> trainingExperiences = trainingExperienceMapper.selectListByTeacherId(id);
        List<EducationExperience> educationExperiences = educationExperienceMapper.findByTeacherId(id);
        BeanUtils.copyProperties(teacherApplyInfo, teacherApplyDetailResult);
        teacherApplyDetailResult.setJobExperienceList(jobExperiences);
        teacherApplyDetailResult.setWorkExperienceList(workExperiences);
        teacherApplyDetailResult.setTrainingExperienceList(trainingExperiences);
        teacherApplyDetailResult.setEducationExperienceList(educationExperiences);
        return teacherApplyDetailResult;
    }
}
