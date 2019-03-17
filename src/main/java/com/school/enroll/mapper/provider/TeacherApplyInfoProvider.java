package com.school.enroll.mapper.provider;

import com.school.enroll.vo.TeacherInfoQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class  TeacherApplyInfoProvider {
    public String  findTeacherByParams(@Param("param") TeacherInfoQueryVo teacherInfoQueryVo){
        SQL sql = new SQL(){{
            SELECT("*");
            FROM("teacher_apply_info");
            if (!StringUtils.isEmpty(teacherInfoQueryVo.getName())) {
                WHERE("name = #{param.name}");
            }
            if (!StringUtils.isEmpty(teacherInfoQueryVo.getStatus())) {
                WHERE("status = #{param.status}");
            }
            if (!StringUtils.isEmpty(teacherInfoQueryVo.getStartTime())) {
                WHERE("DATE_FORMAT(create_time,'%Y-%m-%d') >= #{param.startTime}");
            }
            if (!StringUtils.isEmpty(teacherInfoQueryVo.getEndTime())) {
                WHERE("DATE_FORMAT(create_time,'%Y-%m-%d') < #{param.endTime}");
            }
            ORDER_BY("create_time DESC");

        }};
        return sql.toString();
    }

}
