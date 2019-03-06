package com.school.enroll.vo;

import com.school.enroll.entity.FamilyInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PrimarySchoolApplyVo implements Serializable {
    private static final long serialVersionUID = -5574472109690594076L;

    private PrimaryStudentInfoVo primaryStudentInfoVo;
    private List<FamilyInfo> familyInfos;
}
