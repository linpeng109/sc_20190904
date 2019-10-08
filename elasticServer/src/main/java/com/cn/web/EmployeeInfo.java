package com.cn.web;

import com.cn.elastic.dao.EmployeeDao;
import com.cn.elastic.entity.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeinfo")
@Log4j2
public class EmployeeInfo {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/insert/{num}")
    public String save(@PathVariable("num") int num) {
        for (int i = 0; i < num; ++i) {
            Employee employee = new Employee();
            employeeDao.save(employee);
            log.debug(employee.getId());
        }
        return "Success";
    }

    @RequestMapping("/count")
    public long count() {
        return employeeDao.count();
    }
}
