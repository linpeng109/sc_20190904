package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "productor")
@Inheritance(strategy = InheritanceType.JOINED)
@GenericGenerator(name = "productor-uuid", strategy = "uuid")
@Data
public class Productor implements Serializable {
    @Id
    @GeneratedValue(generator = "productor-uuid")
    @Column(name = "productorId", length = 32)
    public String productorId;

    @Column(name = "productorName", length = 50, nullable = false)
    public String productorName;

    @Column(name = "context", length = 200)
    public String context;

    @Column(name = "createTime")
    public Date createTime;

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable;

    @Column(name = "orderNum")
    @Type(type = "java.lang.Integer")
    public int orderNum;

    @ManyToMany
    @JoinTable(name = "productor_picture",
            joinColumns = {@JoinColumn(name = "productorId", referencedColumnName = "productorId")},
            inverseJoinColumns = {@JoinColumn(name = "pictureId", referencedColumnName = "pictureId")})
    public List<Picture> pictureList = new ArrayList<Picture>();
}
