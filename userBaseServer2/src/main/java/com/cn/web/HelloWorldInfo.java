package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloinfo")
public class HelloWorldInfo {
    @RequestMapping("/hello")
    public String getHello() {
        return "Hello World 2";
    }
}
