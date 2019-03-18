package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.EducationExperience;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EducationExperienceMapper extends BaseMapper<EducationExperience> {
    @Select("select * from education_experience where teacher_id = #{teacherId}")
    List<EducationExperience> findByTeacherId(Long teacherId);
    @Delete("delete from education_experience where teacher_id = #{id}")
    void deleteByTeacherId(Long id);
}
