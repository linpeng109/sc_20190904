package com.cn.web.service;

import com.cn.elastic.dao.EmployeeDao;
import com.cn.elastic.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    public long count() {
        return employeeDao.count();
    }
}
