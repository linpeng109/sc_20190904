package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "picture")
@GenericGenerator(name = "picture-uuid", strategy = "uuid")
@Data
public class Picture {
    @Id
    @GeneratedValue(generator = "picture-uuid")
    @Column(name = "pictureId", length = 32)
    public String pictureId;

    @Column(name = "descript", length = 100, nullable = false, unique = true)
    public String descript;

    @Column(name = "url", length = 200, nullable = false)
    public String url;
}

