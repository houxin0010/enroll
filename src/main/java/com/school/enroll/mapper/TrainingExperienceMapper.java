package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.TrainingExperience;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingExperienceMapper extends BaseMapper<TrainingExperience> {
    @Select("select * from training_experience where teacher_id = #{teacherId}")
    List<TrainingExperience> selectListByTeacherId(Long teacherId);
}
