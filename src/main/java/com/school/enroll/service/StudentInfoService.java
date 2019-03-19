package com.school.enroll.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.result.StudentInfoDetailResult;
import com.school.enroll.vo.FullEnrollStudentInfo;
import com.school.enroll.vo.MiddleSchoolApplyVo;
import com.school.enroll.vo.PrimarySchoolApplyVo;
import com.school.enroll.vo.StudentInfoVo;

import java.util.List;

public interface StudentInfoService {

    IPage<StudentInfo> getPrimaryStudentInfo(Page<StudentInfo> page, StudentInfoVo studentInfoVo);

    List<StudentInfo> getStudentInfoByOpenId(String openId, Integer type);

    IPage<StudentInfo> getMiddleStudentInfo(Page<StudentInfo> page, StudentInfoVo studentInfoVo);

    int updateStudentStatus(Long id, String status);

    void createPrimaryStudentInfo(PrimarySchoolApplyVo primarySchoolApplyVo, String openId);

    void createMiddleStudentInfo(MiddleSchoolApplyVo middleSchoolApplyVo, String openId);

    StudentInfoDetailResult getStudentInfoDetail(Long id);

    FullEnrollStudentInfo getFullEnrollStudentInfo(Long id);

    int delete(Long id);
}
