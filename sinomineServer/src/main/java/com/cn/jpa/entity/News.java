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
@DiscriminatorColumn(name = "newtype", length = 31)
@GenericGenerator(name = "news-uuid", strategy = "uuid")
@Table(name = "news")
@Data
public class News implements Serializable {
    @Id
    @GeneratedValue(generator = "news-uuid")
    @Column(length = 32, name = "newsId")
    public String newsId;

    @Column(name = "newtitle", length = 100)
    public String newtitle;

    @Column(name = "orderNum", unique = true, nullable = false)
    @Type(type = "java.lang.Integer")
    public int orderNum;

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable;

    @Column(name = "createTime")
    @Type(type = "java.util.Date")
    public Date createTime = new Date();

    @Column(name = "newscontext", length = 255, nullable = false)
    public String newscontext;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "news_picture",
            joinColumns = {@JoinColumn(name = "newsId", referencedColumnName = "newsId")},
            inverseJoinColumns = {@JoinColumn(name = "pictureId", referencedColumnName = "pictureId")})
    public List<Picture> pictures = new ArrayList<Picture>();

}
