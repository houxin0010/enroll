package com.school.enroll.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobExperienceVo implements Serializable {
    private static final long serialVersionUID = 3843398822746247383L;

    private String jobTitle;
    private String promotionDate;
    private String promotionUnit;
    private String ratifyUnit;
}
