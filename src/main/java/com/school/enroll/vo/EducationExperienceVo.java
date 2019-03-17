package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EducationExperienceVo implements Serializable {
    private static final long serialVersionUID = 8856410887704792399L;

    private String startTime;
    private String endTime;
    private String schoolName;
    private Long education;
    private String profession;
    private String credential;
}
