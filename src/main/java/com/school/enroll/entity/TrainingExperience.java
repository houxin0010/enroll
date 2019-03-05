package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TrainingExperience implements Serializable {

    private static final long serialVersionUID = 8623711546531641620L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date startTime;
    private Date endTime;
    private String trainingContent;
    private String trainingInstitution;
    private String trainingResult;
    private Long teacherId;

}
