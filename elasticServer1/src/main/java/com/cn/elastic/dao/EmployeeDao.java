package com.cn.elastic.dao;

import com.cn.elastic.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface EmployeeDao extends ElasticsearchCrudRepository<Employee, String> {
}
