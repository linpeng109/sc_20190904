package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
<<<<<<< HEAD
@RequestMapping("/")
public class HelloInfo {
    @RequestMapping("helloinfo")
=======
@RequestMapping("/helloinfo")
public class HelloInfo {
    @RequestMapping("hello")
>>>>>>> b7200e986c883b89223435b0905f1deeedca7097
    public String hello() {
        return "hello world!";
    }
}
