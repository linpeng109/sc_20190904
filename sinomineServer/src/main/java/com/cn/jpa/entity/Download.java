package com.cn.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "download")
@GenericGenerator(name = "download-uuid", strategy = "uuid")
@Data
public class Download implements Serializable {
    @Id
    @GeneratedValue(generator = "download-uuid")
    @Column(name = "downloadId", length = 32)
    public String downloadId;

    @Column(name = "descript", length = 50)
    public String descript;

    @Column(name = "logoUrl", length = 50)
    public String logoUrl;

    @Column(name = "ftpUrl", length = 100)
    public String ftpUrl;

}
