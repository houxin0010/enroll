package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.mapper.provider.TeacherApplyInfoProvider;
import com.school.enroll.vo.TeacherInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherApplyInfoMapper extends BaseMapper<TeacherApplyInfo> {
    @SelectProvider(type = TeacherApplyInfoProvider.class, method = "findTeacherByParams")
    List<TeacherApplyInfo>  findTeacherByParams(@Param("param") TeacherInfoVo teacherInfoVo);
}
