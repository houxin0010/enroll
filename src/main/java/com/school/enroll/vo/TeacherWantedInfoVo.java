package com.school.enroll.vo;

import com.school.enroll.entity.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherWantedInfoVo implements Serializable {
    private static final long serialVersionUID = 2058291341973012062L;

    private TeacherApplyInfo teacherApplyInfo;
    private WorkExperience workExperience;
    private TrainingExperience trainingExperience;
    private JobExperience jobExperience;
    private EducationExperience educationExperience;
}
