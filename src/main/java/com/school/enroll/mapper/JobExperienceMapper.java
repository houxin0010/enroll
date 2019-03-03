package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.JobExperience;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobExperienceMapper extends BaseMapper<JobExperience> {
    @Select("select * from job_experience where teacher_id =#{teacherId}")
    List<JobExperience> selectListByTeacherId(Long teacherId);
}
