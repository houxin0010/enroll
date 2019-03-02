package com.school.enroll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.enroll.entity.StudentInfo;
import com.school.enroll.mapper.provider.StudentInfoProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {

    @SelectProvider(type = StudentInfoProvider.class, method = "findByFieldSql")
    List<StudentInfo> findByField(@Param("name") String name, @Param("status") String status, @Param("type") int type,
                                  @Param("startTime") String startTime, @Param("endTime") String endTime);
}
