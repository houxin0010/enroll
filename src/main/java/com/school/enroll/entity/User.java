package com.school.enroll.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -8327767988426386235L;
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private Date lastLoginTime;

    public User(User user) {
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.telephone = user.getTelephone();
        this.email = user.getEmail();
        this.lastLoginTime = user.getLastLoginTime();
    }

}
