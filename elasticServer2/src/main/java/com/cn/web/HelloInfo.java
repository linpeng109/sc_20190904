package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloinfo")
public class HelloInfo {
    @RequestMapping("hello")
    public String hello(){
        return "Scuess ElasticServer !";
    }
}
