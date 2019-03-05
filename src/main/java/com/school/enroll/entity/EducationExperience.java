package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EducationExperience implements Serializable {

    private static final long serialVersionUID = 52946845687606299L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date startTime;
    private Date endTime;
    private String schoolName;
    private Long education;
    private String profession;
    private String credential;
    private Long teacherId;

}
