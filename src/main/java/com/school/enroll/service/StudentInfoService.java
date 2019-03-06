package com.school.enroll.service;

import com.school.enroll.entity.StudentInfo;
import com.school.enroll.result.StudentInfoDetailResult;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.MiddleSchoolApplyVo;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import com.school.enroll.vo.StudentInfoVo;

import java.util.List;

public interface StudentInfoService {

    List<StudentInfo> getPrimaryStudentInfo(StudentInfoVo studentInfoVo);

    List<StudentInfo> getStudentInfoByOpenId(String openId, Integer type);

    List<StudentInfo> getMiddleStudentInfo(StudentInfoVo studentInfoVo);

    int updateStudentStatus(Long id, String status);

    void createPrimaryStudentInfo(PrimarySchoolApplyVo primarySchoolApplyVo, String openId);

    void createMiddleStudentInfo(MiddleSchoolApplyVo middleSchoolApplyVo, String openId);

    StudentInfoDetailResult getStudentInfoDetail(Long id);

    FullEnrollStudentInfo getFullEnrollStudentInfo(Long id);
}
