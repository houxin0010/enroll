package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = -5163024720546080613L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Long sex;
    private String nation;
    private Date birthdate;
    private String idNo;
    private String primarySchool;
    private String studentCode;
    private String domicilePlace;
    private String homeAddress;
    private Long phoneNo;
    private String selfIntroduction;
    private String status;
    private Integer type;
    private String note;
    private Date createTime;
    private Date updateTime;

}
