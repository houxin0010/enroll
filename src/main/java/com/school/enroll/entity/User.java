package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8327767988426386235L;
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private Date lastLoginTime;

}
