package com.cn.web;

import com.cn.elastic.entity.Employee;
import com.cn.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/elasticinfo")
public class ElasticInfo {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/save/{num}")
    public List<Employee> save(@PathVariable("num") int num) {
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i < num; ++i) {
            Employee employee = new Employee();
            employee.id = UUID.randomUUID().toString();
            employee.createTime = new Date();
            list.add(employeeService.save(employee));
        }
        return list;
    }

    @RequestMapping("/count")
    public long count() {
        return employeeService.count();
    }
}
