package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HonorInfo implements Serializable {

    private static final long serialVersionUID = -744157710683587429L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String honorRoll;
    private Long level;
    private String certificate;
    private Long meritStudent;
    private Long redScarf;
    private String schoolPositionFour;
    private String schoolPositionFive;
    private String schoolPositionSix;
    private Long studentId;
    private String otherHonor;

}
