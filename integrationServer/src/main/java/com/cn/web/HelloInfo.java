package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloInfo {
    @RequestMapping("helloinfo")
    public String hello() {
        return "hello world!";
    }
}
