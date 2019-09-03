package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authoritybase")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Data
public class Authority implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "authorityid",length = 32)
    public String authorityId;

    @Column(name = "authorityname", length = 32, unique = true, nullable = false)
    public String authorityName;

    @Column(name = "authorityDescript", length = 32)
    public String authorityDescript;

}
