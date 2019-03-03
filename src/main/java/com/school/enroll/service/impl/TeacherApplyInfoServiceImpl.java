package com.school.enroll.service.impl;

import com.school.enroll.entity.JobExperience;
import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.entity.TrainingExperience;
import com.school.enroll.entity.WorkExperience;
import com.school.enroll.mapper.JobExperienceMapper;
import com.school.enroll.mapper.TeacherApplyInfoMapper;
import com.school.enroll.mapper.TrainingExperienceMapper;
import com.school.enroll.mapper.WorkExperienceMapper;
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
    public TeacherApplyDetailResult getTeacherApplyInfoDetail(Long id) {
        TeacherApplyDetailResult teacherApplyDetailResult = new TeacherApplyDetailResult();
        TeacherApplyInfo teacherApplyInfo = teacherApplyInfoMapper.selectById(id);
        List<JobExperience> jobExperiences = jobExperienceMapper.selectListByTeacherId(id);
        List<WorkExperience> workExperiences = workExperienceMapper.selectListByTeacherId(id);
        List<TrainingExperience> trainingExperiences = trainingExperienceMapper.selectListByTeacherId(id);
        BeanUtils.copyProperties(teacherApplyInfo,teacherApplyDetailResult);
        teacherApplyDetailResult.setJobExperienceList(jobExperiences);
        teacherApplyDetailResult.setWorkExperienceList(workExperiences);
        teacherApplyDetailResult.setTrainingExperienceList(trainingExperiences);
        return teacherApplyDetailResult;
    }
}
