package com.cn.ftp;

import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.util.IoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FtpServerManager {
    @Autowired
    private FtpServerFtplet ftpServerFtplet;

    public FtpServer create() throws IOException {
        //Build Listener
        DataConnectionConfigurationFactory dataConnectionConfigurationFactory = new DataConnectionConfigurationFactory();
        ListenerFactory listenerFactory = new ListenerFactory();
        listenerFactory.setDataConnectionConfiguration(dataConnectionConfigurationFactory.createDataConnectionConfiguration());
        listenerFactory.setPort(2221);
        Listener listener = listenerFactory.createListener();

        //Build UserManager
        String tmpPath = System.getProperty("java.io.tmpdir") + System.currentTimeMillis() + ".properties";
        File tmpConfig = new File(tmpPath);
        ClassPathResource classPathResource = new ClassPathResource("properties/user.properties");
        IoUtils.copy(classPathResource.getInputStream(), new FileOutputStream(tmpConfig), 1024);
        PropertiesUserManagerFactory propertiesUserManagerFactory = new PropertiesUserManagerFactory();
        propertiesUserManagerFactory.setFile(tmpConfig);
        propertiesUserManagerFactory.setPasswordEncryptor(new ClearTextPasswordEncryptor());
        UserManager userManager = propertiesUserManagerFactory.createUserManager();

        //Build Ftplit
        Map<String, Ftplet> ftpServerFtplets = new HashMap<>();
        ftpServerFtplets.put("default", ftpServerFtplet);

        //Build FtpServer
        FtpServerFactory ftpServerFactory = new FtpServerFactory();
        ftpServerFactory.addListener("default", listener);
        ftpServerFactory.setUserManager(userManager);
        ftpServerFactory.setFtplets(ftpServerFtplets);
        FtpServer ftpServer = ftpServerFactory.createServer();

        return ftpServer;
    }
}
