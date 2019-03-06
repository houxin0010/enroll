package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FamilyInfoVo implements Serializable {
    private static final long serialVersionUID = 4859782493249860093L;

    private String name;
    private Long salutation;
    private Long education;
    private String workUnit;
    private String position;
    private String phoneNo;
    private Long studentId;
}
