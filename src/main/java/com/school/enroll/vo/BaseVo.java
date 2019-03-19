package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseVo implements Serializable {
    private static final long serialVersionUID = 2487371818511405665L;

    private Integer page = 1;
    private Integer size = 10;
    private String startTime;
    private String endTime;

}
