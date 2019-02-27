package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeacherApplyInfo implements Serializable {

    private static final long serialVersionUID = 1852304919774224553L;
    private Long id;
    private String name;
    private String pictureUrl;
    private Long sex;
    private Long idNo;
    private Date birthdate;
    private String nation;
    private Long politicsStatus;
    private String domicilePlace;
    private Long accountProperties;
    private String maritalStatus;
    private String email;
    private Long phoneNo;
    private Long education;
    private String profession;
    private Long englishLevel;
    private String teacherCertification;
    private String professionalTitle;
    private String applyPhaseStudying;
    private String applySubject;
    private String status;
    private String note;
    private Date createTime;
    private Date updateTime;

}
