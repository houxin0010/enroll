package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EducationExperience implements Serializable {

    private static final long serialVersionUID = 52946845687606299L;
    private Long id;
    private Date startTime;
    private Date endTime;
    private String schoolName;
    private Long education;
    private String profession;
    private String credential;
    private Long teacherId;

}
