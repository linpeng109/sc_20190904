package com.cn.kafka;

import com.cn.elastic.entity.Employee;
import com.cn.web.service.ElasticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class KafkaConsumer {

    @Autowired
    private ElasticService employeeService;

    @KafkaListener(topics = {"test2"})
    public String receive(String message) {
        Employee employee = new Employee();
        String randomStr = UUID.randomUUID().toString();
        employee.setFirstName(randomStr.substring(0, 10));
        employee.setLastName(randomStr.substring(11));
        employeeService.save(employee);
        log.debug("received:" + employee);
        return employee.toString();
    }
}
