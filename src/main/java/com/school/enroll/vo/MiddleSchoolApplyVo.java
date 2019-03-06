package com.school.enroll.vo;

import com.school.enroll.entity.FamilyInfo;
import com.school.enroll.entity.HonorInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MiddleSchoolApplyVo implements Serializable {
    private static final long serialVersionUID = -3129435023628340671L;

    private MiddleStudentInfoVo middleStudentInfoVo;
    private HonorInfo honorInfo;
    private List<FamilyInfo> familyInfos;
}
