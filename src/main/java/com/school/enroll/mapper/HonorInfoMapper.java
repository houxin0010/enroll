package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.HonorInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HonorInfoMapper extends BaseMapper<HonorInfo> {
    @Select("select * from honor_info where student_id = #{studentId}")
    HonorInfo findByStudentId(Long studentId);
    @Delete("delete from honor_info where student_id=#{id}")
    void deleteByStudentId(Long id);
}
