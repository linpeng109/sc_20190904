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

    @Column(length = 32)
    public String userpassword;

    @Column(name = "home_directory", length = 200)
    public String homedirectory;

    @Column(name = "enable_flag")
    @Type(type = "java.lang.Boolean")
    public boolean enableflag;

    @Column(name = "write_permission")
    @Type(type = "java.lang.Boolean")
    public boolean writepermission;

    @Column(name = "idle_time")
    @Type(type = "java.lang.Long")
    public long idletime;

    @Column(name = "upload_rate")
    @Type(type = "java.lang.Long")
    public long uploadrate;

    @Column(name = "download_rate")
    @Type(type = "java.lang.Long")
    public long downloadrate;

    @ManyToMany
    @JoinTable(name = "ftpuser_ftpauthority",
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "authorityid", referencedColumnName = "authorityid")})
    public List<FtpAuthority> authorities = new ArrayList<FtpAuthority>();

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public List<? extends Authority> getAuthorities(Class<? extends Authority> aClass) {
        return null;
    }

    @Override
    public AuthorizationRequest authorize(AuthorizationRequest authorizationRequest) {
        return null;
    }

    @Override
    public int getMaxIdleTime() {
        return 0;
    }

    @Override
    public boolean getEnabled() {
        return false;
    }

    @Override
    public String getHomeDirectory() {
        return null;
    }
}
