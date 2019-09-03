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
@Table(name = "userbase")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Data
public class UserBase implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "userid", length = 32)
    public String userId;

    @Column(name = "username", length = 32, unique = true)
    public String username;

    @Column(name = "password", length = 32)
    public String password;

    @Column(name = "createdate")
    @Type(type = "java.util.Date")
    public Date createDate = new Date();

    @Column(name = "enable")
    @Type(type = "java.lang.Boolean")
    public boolean enable = true;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "userbase_authority",
            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "authorityId", referencedColumnName = "authorityId")}
    )
    public List<Authority> authoritys = new ArrayList<Authority>();
}
