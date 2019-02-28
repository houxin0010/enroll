package com.school.enroll.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

public class StudentInfoProvider {

    public String findByFieldSql(){
        return new SQL(){{

        }}.toString();
    }
}
