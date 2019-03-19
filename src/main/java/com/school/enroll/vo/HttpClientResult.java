package com.school.enroll.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * HttpClientResult
 *
 * @author houxin
 * @date 2019/3/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpClientResult implements Serializable {
    private static final long serialVersionUID = -7948601936661685112L;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应数据
     */
    private String content;
}
