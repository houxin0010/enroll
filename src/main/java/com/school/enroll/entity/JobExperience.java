package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JobExperience implements Serializable {

    private static final long serialVersionUID = 755169981348423896L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String jobTitle;
    private Date promotionDate;
    private String promotionUnit;
    private String ratifyUnit;
    private Long teacherId;

}
