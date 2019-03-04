package com.school.enroll.result;

import com.school.enroll.entity.FamilyInfo;
import com.school.enroll.entity.HonorInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StudentInfoDetailResult implements Serializable {
    private static final long serialVersionUID = -5163024720546080613L;
    private Long id;
    private String name;
    private Long sex;
    private String nation;
    private Date birthdate;
    private String idNo;
    private String primarySchool;
    private String studentCode;
    private String domicilePlace;
    private String homeAddress;
    private Long phoneNo;
    private String selfIntroduction;
    private String status;
    private String type;
    private String note;
    private Date createTime;
    private Date updateTime;
    private List<FamilyInfo> familyInfoList;
    private List<HonorInfo> honorInfoList;

}
