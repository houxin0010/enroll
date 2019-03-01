package com.school.enroll;

import com.alibaba.fastjson.JSON;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.mapper.StudentInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrollApplicationTests {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Test
    public void contextLoads() {
//        List<StudentInfo> studentInfos = studentInfoMapper.findByField("学生1", "", "", "");

        log.info("result = {} - {}", String.valueOf(System.currentTimeMillis()), new Date().getTime());
    }

}
