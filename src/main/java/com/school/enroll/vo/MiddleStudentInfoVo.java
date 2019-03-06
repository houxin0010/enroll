package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MiddleStudentInfoVo implements Serializable {
    private static final long serialVersionUID = 4075135926151669231L;

    private String name;
    private Long sex;
    private String nation;
    private String birthdate;
    private String idNo;
    private String primarySchool;
    private String studentCode;
    private String schoolRollPlace;
    private String domicilePlace;
    private String homeAddress;
    private String phoneNo;
    private String selfIntroduction;
}
