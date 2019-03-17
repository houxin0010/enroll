package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TeacherWantedInfoVo implements Serializable {
    private static final long serialVersionUID = 2058291341973012062L;

    private TeacherInfoVo teacherInfoVo;
    private List<WorkExperienceVo> workExperienceVos;
    private List<TrainingExperienceVo> trainingExperienceVos;
    private List<JobExperienceVo> jobExperienceVos;
    private List<EducationExperienceVo> educationExperienceVos;
}
