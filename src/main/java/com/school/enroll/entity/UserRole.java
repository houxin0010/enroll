package com.school.enroll.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 2501828614875633731L;
    private Long id;
    private Long roleId;
    private Long userId;

}
