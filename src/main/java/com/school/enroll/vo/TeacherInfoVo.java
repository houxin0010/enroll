package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherInfoVo implements Serializable {
    private static final long serialVersionUID = 4830823106992849522L;

    private String name;
    private String pictureUrl;
    private Long sex;
    private String idNo;
    private String birthdate;
    private String nation;
    private Long politicsStatus;
    private String domicilePlace;
    private Long accountProperties;
    private Long maritalStatus;
    private String email;
    private String phoneNo;
    private Long education;
    private String profession;
    private Long englishLevel;
    private Long teacherCertification;
    private Long professionalTitle;
    private Long applyPhaseStudying;
    private Long applySubject;
}
