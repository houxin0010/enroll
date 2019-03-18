package com.school.enroll.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.school.enroll.entity.FamilyInfo;
import com.school.enroll.entity.HonorInfo;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.enums.StatusEnum;
import com.school.enroll.mapper.FamilyInfoMapper;
import com.school.enroll.mapper.HonorInfoMapper;
import com.school.enroll.mapper.StudentInfoMapper;
import com.school.enroll.result.StudentInfoDetailResult;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Autowired
    private FamilyInfoMapper familyInfoMapper;

    @Autowired
    private HonorInfoMapper honorInfoMapper;

    @Override
    public List<StudentInfo> getPrimaryStudentInfo(StudentInfoVo studentInfoVo) {
        log.info("studentInfoVo = {}", JSON.toJSONString(studentInfoVo));
        return studentInfoMapper.findByField(studentInfoVo.getName(), studentInfoVo.getStatus(), 0,
                studentInfoVo.getStartTime(), studentInfoVo.getEndTime());
    }

    @Override
    public List<StudentInfo> getStudentInfoByOpenId(String openId, Integer type) {
        return studentInfoMapper.selectList(new LambdaQueryWrapper<StudentInfo>()
                .eq(StudentInfo::getOpenId, openId)
                .eq(StudentInfo::getType, type)
                .orderByDesc(StudentInfo::getCreateTime));
    }

    @Override
    public List<StudentInfo> getMiddleStudentInfo(StudentInfoVo studentInfoVo) {

        log.info("studentInfoVo = {}", JSON.toJSONString(studentInfoVo));
        return studentInfoMapper.findByField(studentInfoVo.getName(), studentInfoVo.getStatus(), 1,
                studentInfoVo.getStartTime(), studentInfoVo.getEndTime());
    }

    @Override
    public int updateStudentStatus(Long id, String status) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(id);
        studentInfo.setStatus(status);
        return studentInfoMapper.updateById(studentInfo);
    }

    @Override
    public void createPrimaryStudentInfo(PrimarySchoolApplyVo primarySchoolApplyVo, String openId) {
        PrimaryStudentInfoVo primaryStudentInfoVo = primarySchoolApplyVo.getPrimaryStudentInfoVo();
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setOpenId(openId);
        BeanUtils.copyProperties(primaryStudentInfoVo, studentInfo);
        try {
            studentInfo.setBirthdate(new SimpleDateFormat("yyyy年M月d日").parse(primaryStudentInfoVo.getBirthdate()));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            studentInfo.setBirthdate(null);
        }
        studentInfo.setCreateTime(new Date());
        studentInfo.setStatus(StatusEnum.AUDIT.getCode());
        studentInfo.setType(0);
        studentInfoMapper.insert(studentInfo);
        primarySchoolApplyVo.getFamilyInfos().forEach(familyInfo -> {
            if (!StringUtils.isEmpty(familyInfo.getName())) {
                familyInfo.setStudentId(studentInfo.getId());
                familyInfoMapper.insert(familyInfo);
            }
        });
    }

    @Override
    public void createMiddleStudentInfo(MiddleSchoolApplyVo middleSchoolApplyVo, String openId) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setOpenId(openId);
        MiddleStudentInfoVo middleStudentInfoVo = middleSchoolApplyVo.getMiddleStudentInfoVo();
        BeanUtils.copyProperties(middleStudentInfoVo, studentInfo);
        try {
            studentInfo.setBirthdate(new SimpleDateFormat("yyyy年M月d日").parse(middleStudentInfoVo.getBirthdate()));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            studentInfo.setBirthdate(null);
        }
        studentInfo.setCreateTime(new Date());
        studentInfo.setStatus(StatusEnum.AUDIT.getCode());
        studentInfo.setType(1);
        studentInfoMapper.insert(studentInfo);

        middleSchoolApplyVo.getFamilyInfos().forEach(familyInfo -> {
            if (!StringUtils.isEmpty(familyInfo.getName())) {
                familyInfo.setStudentId(studentInfo.getId());
                familyInfoMapper.insert(familyInfo);
            }
        });
        HonorInfo honorInfo = middleSchoolApplyVo.getHonorInfo();
        honorInfo.setStudentId(studentInfo.getId());
        honorInfoMapper.insert(honorInfo);
    }

    @Override
    public StudentInfoDetailResult getStudentInfoDetail(Long id) {
        StudentInfoDetailResult studentInfoDetailResult = new StudentInfoDetailResult();
        StudentInfo studentInfo = studentInfoMapper.selectById(id);
        BeanUtils.copyProperties(studentInfo, studentInfoDetailResult);
        List<FamilyInfo> familyInfos = familyInfoMapper.findByStudentId(id);
        HonorInfo honorInfo = honorInfoMapper.findByStudentId(id);
        if (null != honorInfo) {
            BeanUtils.copyProperties(honorInfo, studentInfoDetailResult);
        }
        studentInfoDetailResult.setFamilyInfoList(familyInfos);

        return studentInfoDetailResult;
    }

    @Override
    public FullEnrollStudentInfo getFullEnrollStudentInfo(Long id) {
        FullEnrollStudentInfo fullEnrollStudentInfo = new FullEnrollStudentInfo();
        StudentInfo studentInfo = studentInfoMapper.selectById(id);
        fullEnrollStudentInfo.setStudentInfo(studentInfo);

        List<FamilyInfo> familyInfoList = familyInfoMapper.selectList(new LambdaQueryWrapper<FamilyInfo>()
                .eq(FamilyInfo::getStudentId, id));
        fullEnrollStudentInfo.setFamilyInfoList(familyInfoList);

        HonorInfo honorInfo = honorInfoMapper.findByStudentId(id);
        fullEnrollStudentInfo.setHonorInfo(honorInfo);

        return fullEnrollStudentInfo;
    }

    @Override
    public int delete(Long id) {
        int i = studentInfoMapper.deleteById(id);
        familyInfoMapper.deleteByStudentId(id);
        honorInfoMapper.deleteByStudentId(id);
        return i;
    }

}
