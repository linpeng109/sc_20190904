package com.cn.elastic.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.UUID;

@Data
@Document(indexName = "employeeindex", type = "Employee")
public class Employee {
    @Id
    public String id = UUID.randomUUID().toString();
    @Field(type = FieldType.Text)
    public String firstName;
    @Field(type = FieldType.Text)
    public String lastName;
    @Field(type = FieldType.Date)
    public Date createTime = new Date();
    @Field(type = FieldType.Text)
    public String company;
    @Field(type = FieldType.Text)
    public String about;
}
