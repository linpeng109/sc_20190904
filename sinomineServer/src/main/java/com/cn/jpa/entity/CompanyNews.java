package com.cn.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CompanyNews")
public class CompanyNews extends News {
}
