package com.cn.ftp;

import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Configuration
public class MyFtpServer {
    public void init() throws IOException {
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory listenerFactory = new ListenerFactory();
        listenerFactory.setPort(3131);
        //设置被动模式数据上传的接口范围,云服务器需要开放对应区间的端口给客户端
        DataConnectionConfigurationFactory dataConnectionConfFactory = new DataConnectionConfigurationFactory();
        dataConnectionConfFactory.setPassivePorts("10000-10100");
        listenerFactory.setDataConnectionConfiguration(dataConnectionConfFactory.createDataConnectionConfiguration());
        Listener listener = listenerFactory.createListener();

        serverFactory.addListener("default", listener);
        //第二步中的FtpService,由于FtpService是作为配置(@Configration)启动,因此可以直接通过@Autowire获取实例。
        Map<String, Ftplet> ftpLets= Collections.unmodifiableMap(new Map());
        ftpLets.put("ftpService", service);
        serverFactory.setFtplets(ftpLets);
        //配置文件:位于resources/properties目录下,FTPServer无法直接直接读取Jar包中的配置文件。将文件复制到指定目录(本文指定到根目录)下然后FTPServer才能读取。
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        String tempPath = System.getProperty("java.io.tmpdir") + System.currentTimeMillis() + ".properties";
        File tempConfig = new File(tempPath);


        ClassPathResource resource = new ClassPathResource("properties/users.properties");
        IOUtils.copy(resource.getInputStream(), new FileOutputStream(tempConfig));
        userManagerFactory.setFile(tempConfig);
        userManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor());
        serverFactory.setUserManager(userManagerFactory.createUserManager());
        server = serverFactory.createServer();
    }
}
