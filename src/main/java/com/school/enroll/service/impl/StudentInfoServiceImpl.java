package com.school.enroll.service.impl;

import com.alibaba.fastjson.JSON;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.enums.StatusEnum;
import com.school.enroll.mapper.StudentInfoMapper;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.PrimaryStudentInfoVo;
import com.school.enroll.vo.StudentInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public List<StudentInfo> getPrimaryStudentInfo(StudentInfoVo studentInfoVo) {

        log.info("studentInfoVo = {}", JSON.toJSONString(studentInfoVo));
        return studentInfoMapper.findByField(studentInfoVo.getName(), studentInfoVo.getStatus(), 0,
                studentInfoVo.getStartTime(), studentInfoVo.getEndTime());
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
    public void createStudentInfo(PrimaryStudentInfoVo primaryStudentInfoVo) {
        StudentInfo studentInfo = new StudentInfo();
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
    }

}
