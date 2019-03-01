package com.school.enroll.mapper.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class StudentInfoProvider {

    public String findByFieldSql(@Param("name") String name, @Param("status") String status,
                                 @Param("startTime") String startTime, @Param("endTime") String endTime) {
        return new SQL() {{
            SELECT("*");
            FROM("student_info");
            if (!StringUtils.isEmpty(name)) {
                WHERE("name = #{name}");
            }
            if (!StringUtils.isEmpty(status)) {
                WHERE("status = #{status}");
            }
            if (!StringUtils.isEmpty(startTime)) {
                WHERE("create_time >= #{startTime}");
            }
            if (!StringUtils.isEmpty(endTime)) {
                WHERE("create_time < #{endTime}");
            }
            ORDER_BY("create_time DESC");
        }}.toString();
    }
}
