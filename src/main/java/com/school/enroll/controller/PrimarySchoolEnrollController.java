package com.school.enroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/primarySchool")
public class PrimarySchoolEnrollController {

    @RequestMapping("/index")
    public String index(){
        return "/wechat/primaryEnroll";
    }
}
