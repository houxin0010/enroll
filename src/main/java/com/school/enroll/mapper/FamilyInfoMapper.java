package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.FamilyInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FamilyInfoMapper extends BaseMapper<FamilyInfo> {
    @Select("select * from family_info where student_id = #{studentId}")
    List<FamilyInfo> findByStudentId(Long studentId);
}
