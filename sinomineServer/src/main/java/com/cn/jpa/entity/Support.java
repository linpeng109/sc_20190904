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
@Table(name = "support")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "supportType", length = 31)
@GenericGenerator(name = "support-uuid", strategy = "uuid")
@Data
public class Support implements Serializable {
    @Id
    @GeneratedValue(generator = "support-uuid")
    @Column(length = 32, name = "supportId")
    public String supportId;

    @Column(length = 32, name = "title")
    public String title;

    @Column(length = 200, name = "context")
    public String context;

    @Type(type = "java.lang.Boolean")
    public boolean enable;

    @Type(type = "java.util.Date")
    @Column(name = "createTime")
    public Date createTime = new Date();

    @Type(type = "java.lang.Integer")
    @Column(name = "orderNum")
    public int orderNum;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "support_picture",
            joinColumns = {@JoinColumn(name = "supportId", referencedColumnName = "supportId")},
            inverseJoinColumns = {@JoinColumn(name = "pictureId", referencedColumnName = "pictureId")})
    public List<Picture> pictureList = new ArrayList<Picture>();
}
