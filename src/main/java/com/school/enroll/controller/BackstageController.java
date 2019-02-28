package com.school.enroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backstage")
public class BackstageController {

    @RequestMapping("/index")
    public String index() {
        return "backstage/index";
    }
}
