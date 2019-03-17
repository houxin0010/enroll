package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TrainingExperienceVo implements Serializable {
    private static final long serialVersionUID = 8298951805378177805L;

    private String startTime;
    private String endTime;
    private String trainingContent;
    private String trainingInstitution;
    private String trainingResult;
}
