package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherInfoVo implements Serializable {

    private static final long serialVersionUID = -7588955928790652895L;
    private String name;
    private String status;
    private String startTime;
    private String endTime;
}
