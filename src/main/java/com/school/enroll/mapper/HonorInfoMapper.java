package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.HonorInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HonorInfoMapper extends BaseMapper<HonorInfo> {
    @Select("select * from honor_info where student_id = #{studentId}")
    List<HonorInfo> findByStudentId(Long studentId);
}
