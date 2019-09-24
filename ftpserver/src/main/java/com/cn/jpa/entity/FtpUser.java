package com.cn.jpa.entity;

import lombok.Data;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;
import org.apache.ftpserver.ftplet.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ftp_user")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Data
public class FtpUser implements User, Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, name = "userid")
    public String userid;

    @Column(name = "username", length = 32, unique = true)
    public String username;

    @Column(length = 32, name = "userpassword")
    public String userpassword;

    @Column(name = "homedirectory", length = 200)
    public String homedirectory = "d:/ftp/" + username;

    @Column(name = "enableflag")
    @Type(type = "java.lang.Boolean")
    public boolean enableflag = true;

    @Column(name = "writepermission")
    @Type(type = "java.lang.Boolean")
    public boolean writepermission = true;

    @Column(name = "idletime")
    @Type(type = "java.lang.Integer")
    public int idletime;

    @Column(name = "uploadrate")
    @Type(type = "java.lang.Long")
    public long uploadrate;

    @Column(name = "downloadrate")
    @Type(type = "java.lang.Long")
    public long downloadrate;

    @ManyToMany
    @JoinTable(name = "ftpuser_ftpauthority",
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "authorityid", referencedColumnName = "authorityid")})
    public List<FtpAuthority> authorities = new ArrayList<FtpAuthority>();

    @Override
    public String getName() {
        return this.getUsername();
    }

    @Override
    public String getPassword() {
        return this.userpassword;
    }

    @Override
    public List<? extends Authority> getAuthorities(Class<? extends Authority> aClass) {
        return this.authorities;
    }

    @Override
    public AuthorizationRequest authorize(AuthorizationRequest authorizationRequest) {
        System.out.println(authorizationRequest.toString());
        return authorizationRequest;
    }

    @Override
    public int getMaxIdleTime() {
        return this.idletime;
    }

    @Override
    public boolean getEnabled() {
        return this.enableflag;
    }

    @Override
    public String getHomeDirectory() {
        return this.homedirectory;
    }
}
