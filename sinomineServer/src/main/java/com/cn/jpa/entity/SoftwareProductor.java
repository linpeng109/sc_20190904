package com.cn.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "softwareProductor")
@PrimaryKeyJoinColumn(name = "softwareId", referencedColumnName = "productorId")
public class SoftwareProductor extends Productor {
    @Column(name = "url", length = 50)
    public String url;
}
