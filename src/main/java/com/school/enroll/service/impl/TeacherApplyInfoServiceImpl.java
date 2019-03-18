package com.school.enroll.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.school.enroll.entity.*;
import com.school.enroll.enums.StatusEnum;
import com.school.enroll.mapper.*;
import com.school.enroll.result.TeacherApplyDetailResult;
import com.school.enroll.service.TeacherApplyInfoService;
import com.school.enroll.vo.TeacherInfoQueryVo;
import com.school.enroll.vo.TeacherInfoVo;
import com.school.enroll.vo.TeacherWantedInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<TeacherApplyInfo> getTeacherApplyInfo(TeacherInfoQueryVo teacherInfoQueryVo) {
        return teacherApplyInfoMapper.findTeacherByParams(teacherInfoQueryVo);
    }

    @Override
    public List<TeacherApplyInfo> getTeacherApplyInfoByOpenId(String openId) {
        return teacherApplyInfoMapper.selectList(new LambdaQueryWrapper<TeacherApplyInfo>()
                .eq(TeacherApplyInfo::getOpenId, openId)
                .orderByDesc(TeacherApplyInfo::getCreateTime));
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTeacherInfo(TeacherWantedInfoVo teacherWantedInfoVo, String openId) {
        try {
            List<TeacherApplyInfo> teacherApplyInfos = teacherApplyInfoMapper.selectList(new QueryWrapper<TeacherApplyInfo>().eq("open_id", openId));
            if (teacherApplyInfos == null || teacherApplyInfos.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                TeacherApplyInfo teacherApplyInfo = new TeacherApplyInfo();
                TeacherInfoVo teacherInfoVo = teacherWantedInfoVo.getTeacherInfoVo();
                BeanUtils.copyProperties(teacherInfoVo, teacherApplyInfo);
                teacherApplyInfo.setBirthdate(simpleDateFormat.parse(teacherInfoVo.getBirthdate()));
                teacherApplyInfo.setStatus(StatusEnum.AUDIT.getCode());
                teacherApplyInfo.setCreateTime(new Date());
                teacherApplyInfo.setOpenId(openId);
                teacherApplyInfoMapper.insert(teacherApplyInfo);
                teacherWantedInfoVo.getEducationExperienceVos().forEach(educationExperienceVo -> {
                    EducationExperience educationExperience = new EducationExperience();
                    BeanUtils.copyProperties(educationExperienceVo, educationExperience);
                    try {
                        educationExperience.setStartTime(simpleDateFormat.parse(educationExperienceVo.getStartTime()));
                        educationExperience.setEndTime(simpleDateFormat.parse(educationExperienceVo.getEndTime()));
                    } catch (ParseException e) {
                        log.error(e.getMessage(), e);
                    }
                    educationExperience.setTeacherId(teacherApplyInfo.getId());
                    if (!StringUtils.isEmpty(educationExperience.getSchoolName())) {
                        educationExperienceMapper.insert(educationExperience);
                    }
                });
                teacherWantedInfoVo.getJobExperienceVos().forEach(jobExperienceVo -> {
                    JobExperience jobExperience = new JobExperience();
                    BeanUtils.copyProperties(jobExperienceVo, jobExperience);
                    if (!StringUtils.isEmpty(jobExperienceVo.getPromotionDate())) {
                        try {
                            jobExperience.setPromotionDate(simpleDateFormat.parse(jobExperienceVo.getPromotionDate()));
                        } catch (ParseException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                    jobExperience.setTeacherId(teacherApplyInfo.getId());
                    if (!StringUtils.isEmpty(jobExperience.getJobTitle())) {
                        jobExperienceMapper.insert(jobExperience);
                    }
                });
                teacherWantedInfoVo.getTrainingExperienceVos().forEach(trainingExperienceVo -> {
                    TrainingExperience trainingExperience = new TrainingExperience();
                    BeanUtils.copyProperties(trainingExperienceVo, trainingExperience);
                    try {
                        if (!StringUtils.isEmpty(trainingExperienceVo.getStartTime())) {
                            trainingExperience.setStartTime(simpleDateFormat.parse(trainingExperienceVo.getStartTime()));
                        }
                        if (!StringUtils.isEmpty(trainingExperienceVo.getEndTime())) {
                            trainingExperience.setEndTime(simpleDateFormat.parse(trainingExperienceVo.getEndTime()));
                        }
                    } catch (ParseException e) {
                        log.error(e.getMessage(), e);
                    }
                    trainingExperience.setTeacherId(teacherApplyInfo.getId());
                    if (!StringUtils.isEmpty(trainingExperience.getTrainingResult())) {
                        trainingExperienceMapper.insert(trainingExperience);
                    }
                });
                teacherWantedInfoVo.getWorkExperienceVos().forEach(workExperienceVo -> {
                    WorkExperience workExperience = new WorkExperience();
                    BeanUtils.copyProperties(workExperienceVo, workExperience);
                    try {
                        if (!StringUtils.isEmpty(workExperienceVo.getStartTime())) {
                            workExperience.setStartTime(simpleDateFormat.parse(workExperienceVo.getStartTime()));
                        }
                        if (!StringUtils.isEmpty(workExperienceVo.getEndTime())) {
                            workExperience.setEndTime(simpleDateFormat.parse(workExperienceVo.getEndTime()));
                        }
                    } catch (ParseException e) {
                        log.error(e.getMessage(), e);
                    }
                    workExperience.setTeacherId(teacherApplyInfo.getId());
                    if (!StringUtils.isEmpty(workExperience.getWorkUnit())) {
                        workExperienceMapper.insert(workExperience);
                    }
                });
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public int deletc(Long id) {
        int i = teacherApplyInfoMapper.deleteById(id);
        jobExperienceMapper.deleteByTeacherId(id);
        workExperienceMapper.deleteByTeacherId(id);
        trainingExperienceMapper.deletcByTeacherId(id);
        educationExperienceMapper.deleteByTeacherId(id);

        return i;
    }
}
