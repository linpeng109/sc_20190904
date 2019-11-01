package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FailBackInfo {
    @RequestMapping("/fallback")
    public Map<String, Object> failBack() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("Code", -100);
        result.put("Message", "目前服务不可用");

        return result;
    }
}
