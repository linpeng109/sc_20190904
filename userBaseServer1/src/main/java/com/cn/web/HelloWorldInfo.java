package com.cn.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloinfo")
public class HelloWorldInfo {
    @RequestMapping("/hello")
    public String getHello() throws Throwable {
        throw new Throwable("aabbcc");
    }
}
