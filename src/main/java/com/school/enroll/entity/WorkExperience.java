package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WorkExperience implements Serializable {

    private static final long serialVersionUID = -702728757203126699L;
    private Long id;
    private Date startTime;
    private Date endTime;
    private String workUnit;
    private String position;
    private String certifierName;
    private Long certifierPhone;
    private String reasonsResignation;
    private Long teacherId;

}
