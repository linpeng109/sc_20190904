package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "productor")
@GenericGenerator(name = "productor-uuid", strategy = "uuid")
@Data
public class Productor implements Serializable {
    @Id
    @GeneratedValue(generator = "productor-uuid")
    @Column(name = "productorId", length = 32)
    public String productorId;

    public String name;
    public String context;
    public Date createTime;
    public boolean enable;
    public int orderNum;
    public List<Picture> pictureList = new ArrayList<Picture>();
}
