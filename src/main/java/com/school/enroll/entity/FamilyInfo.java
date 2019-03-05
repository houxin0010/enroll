package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FamilyInfo implements Serializable {

    private static final long serialVersionUID = -7734003603879804090L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Long salutation;
    private Long education;
    private String workUnit;
    private String position;
    private Long phoneNo;
    private Long studentId;

}
