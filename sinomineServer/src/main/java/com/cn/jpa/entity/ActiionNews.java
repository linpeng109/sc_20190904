package com.cn.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ActiionNews")
public class ActiionNews extends News {
}
