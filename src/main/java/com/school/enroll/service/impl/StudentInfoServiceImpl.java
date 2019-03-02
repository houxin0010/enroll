package com.school.enroll.service.impl;

import com.alibaba.fastjson.JSON;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.mapper.StudentInfoMapper;
import com.school.enroll.service.StudentInfoService;
import com.school.enroll.vo.StudentInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
