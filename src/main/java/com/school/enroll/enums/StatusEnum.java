package com.school.enroll.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    /**
     *
     */
    INIT("INIT","初始化"),
    AUDIT("AUDIT","审核中"),
    PASSED("PASSED","通过"),
    REJECT("REJECT","拒绝");

    private String code;
    private String text;
}
