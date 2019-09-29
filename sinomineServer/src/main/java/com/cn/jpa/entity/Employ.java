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
@Table(name = "employ")
@GenericGenerator(name = "employ-uuid", strategy = "uuid")
@Data
public class Employ implements Serializable {
    @Id
    @GeneratedValue(generator = "employ-uuid")
    @Column(name = "employId", length = 32)
    public String employId;

    @Column(name = "title", unique = true, nullable = false, length = 100)
    public String title;

    @Column(name = "descript")
    public String descript;

    @Column(name = "createTime")
    @Type(type = "java.util.Date")
    public Date createTime = new Date();

    @Column(name = "orderNum")
    @Type(type = "java.lang.Integer")
    public int orderNum;

    @Column(name = "email", length = 50)
    public String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "employId", referencedColumnName = "employId")},
            inverseJoinColumns = {@JoinColumn(name = "pictureId", referencedColumnName = "pictureId")})
    public List<Picture> pictureList = new ArrayList<Picture>();
}
