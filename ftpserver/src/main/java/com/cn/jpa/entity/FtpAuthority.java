package com.cn.jpa.entity;

import lombok.Data;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@GenericGenerator(name = "system-uuid", strategy = "uuid")
@Table(name = "ftp_authority")
@Data
public class FtpAuthority implements Authority,Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, name = "authorityid")
    public String authorityId;

    @Column(name = "ftpauthorityString", length = 32, unique = true)
    public String ftpAuthorityString;

    @Override
    public boolean canAuthorize(AuthorizationRequest authorizationRequest) {
        return false;
    }

    @Override
    public AuthorizationRequest authorize(AuthorizationRequest authorizationRequest) {
        return null;
    }
}
