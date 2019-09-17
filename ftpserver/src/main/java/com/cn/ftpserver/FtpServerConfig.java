package com.cn.ftpserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:ftpserver.xml"})
public class FtpServerConfig {
}
