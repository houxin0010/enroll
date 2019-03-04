package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrimaryStudentInfoVo implements Serializable {
    private static final long serialVersionUID = 2541552360134342917L;

    private String name;
    private Long sex;
    private String nation;
    private String birthdate;
    private String domicilePlace;
    private String homeAddress;
}
