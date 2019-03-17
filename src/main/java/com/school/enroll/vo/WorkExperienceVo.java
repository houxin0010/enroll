package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WorkExperienceVo implements Serializable {
    private static final long serialVersionUID = -1726622979869790255L;

    private String startTime;
    private String endTime;
    private String workUnit;
    private String position;
    private String certifierName;
    private String certifierPhone;
    private String reasonsResignation;
}
