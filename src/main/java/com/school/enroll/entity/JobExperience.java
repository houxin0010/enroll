package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JobExperience implements Serializable {

    private static final long serialVersionUID = 755169981348423896L;
    private Long id;
    private String jobTitle;
    private Date promotionDate;
    private String promotionUnit;
    private String ratifyUnit;
    private Long teacherId;

}
