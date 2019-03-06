package com.school.enroll.vo;

import com.school.enroll.entity.FamilyInfo;
import com.school.enroll.entity.HonorInfo;
import com.school.enroll.entity.StudentInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FullEnrollStudentInfo implements Serializable {
    private static final long serialVersionUID = 7092129594237778295L;

    private StudentInfo studentInfo;
    private HonorInfo honorInfo;
    private List<FamilyInfo> familyInfoList;
}
