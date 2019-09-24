package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "picture")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Data
public class Picture {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "pictureid", length = 32)
    public String pictureid;

    @Column(name = "descript", length = 100, nullable = false, unique = true)
    public String descript;

    @Column(name = "url", length = 200, nullable = false)
    public String url;
}

