package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.WorkExperience;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkExperienceMapper extends BaseMapper<WorkExperience> {
    @Select("select * from work_experience where teacher_id = #{teacherId}")
    List<WorkExperience> selectListByTeacherId(Long teacherId);
    @Select("delete from work_experience where teacher_id = #{id}")
    void deleteByTeacherId(Long id);
}
