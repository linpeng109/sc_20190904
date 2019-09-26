package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloinfo")
public class HelloInfo {
    public String hello() {
        return "Hello ! The Infomation@";
    }
}
