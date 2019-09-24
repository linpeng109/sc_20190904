package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "news", indexes = {})
@Data
public class News implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, name = "newsid")
    public String newsid;

    @Column(name = "newtitle", length = 100)
    public String newtitle;

    @Column(name = "ordernum", unique = true, nullable = false)
    @Type(type = "java.lang.Integer")
    public int ordernum;

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable;

    @Column(name = "createTime")
    @Type(type = "java.util.Date")
    public Date createTime = new Date();

    @Column(name = "newcontext", length = 255, nullable = false)
    public String newscontext;

}
