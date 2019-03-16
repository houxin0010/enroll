package com.school.enroll.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UploadResultVo implements Serializable {
    private static final long serialVersionUID = 3724500254532788520L;

    private String uploadCode;
    private String uploadText;
}
