package com.cn.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ServiceProductor")
@PrimaryKeyJoinColumn(name = "serviceId",referencedColumnName = "productorId")
public class ServiceProductor extends Productor {
}
