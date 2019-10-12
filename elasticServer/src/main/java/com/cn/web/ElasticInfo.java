package com.cn.web;

import com.cn.elastic.entity.Employee;
import com.cn.web.service.ElasticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/elasticinfo")
@Log4j2
public class ElasticInfo {
    @Autowired
    private ElasticService employeeService;

    @RequestMapping("/insert/{num}")
    public String save(@PathVariable("num") int num) {
        for (int i = 0; i < num; ++i) {
            Employee employee = new Employee();
            String randomStr = UUID.randomUUID().toString();
            employee.setFirstName(randomStr.substring(0, 8));
            employee.setLastName(randomStr.substring(9));
            employeeService.save(employee);
            log.debug(employee.getId());
        }
        return "Success";
    }

    @RequestMapping("/count")
    public long count() {
        return employeeService.count();
    }
}
