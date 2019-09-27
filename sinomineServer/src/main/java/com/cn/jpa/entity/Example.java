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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "exampletype")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "example")
@Data
public class Example implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "exampleid", length = 32)
    public String exampleId;

    @Column(name = "title", length = 32)
    public String title;

    @Column(name = "context", length = 200)
    public String context;

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable;

    @Column(name = "createtime")
    @Type(type = "java.util.Date")
    public Date createTime;

    @Column(name = "ordernum")
    @Type(type = "java.lang.Integer")
    public int orderNum;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "exampleId", referencedColumnName = "exampleId")},
            inverseJoinColumns = {@JoinColumn(name = "pictureId", referencedColumnName = "pictureId")})
    public List<Picture> pictures = new ArrayList<Picture>();
}
