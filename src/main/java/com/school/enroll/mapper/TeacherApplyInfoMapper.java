package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.enroll.entity.TeacherApplyInfo;
import com.school.enroll.mapper.provider.TeacherApplyInfoProvider;
import com.school.enroll.vo.TeacherInfoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherApplyInfoMapper extends BaseMapper<TeacherApplyInfo> {
    @SelectProvider(type = TeacherApplyInfoProvider.class, method = "findTeacherByParams")
    IPage<TeacherApplyInfo> findTeacherByParams(Page page, @Param("param") TeacherInfoQueryVo teacherInfoQueryVo);
}
