package com.school.enroll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 8845117295823895054L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String roleCode;
    private String roleName;

}
