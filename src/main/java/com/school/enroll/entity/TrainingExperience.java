package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TrainingExperience implements Serializable {

    private static final long serialVersionUID = 8623711546531641620L;
    private Long id;
    private Date startTime;
    private Date endTime;
    private String trainingContent;
    private String trainingInstitution;
    private String trainingResult;
    private Long teacherId;

}
