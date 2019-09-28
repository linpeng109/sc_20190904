package com.cn.jpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "download")
@GenericGenerator(name = "download-uuid",strategy = "uuid")
public class Download implements Serializable {

}
