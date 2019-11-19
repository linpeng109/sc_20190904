package com.cn.ftp;

import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FtpServerServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils
                .getWebApplicationContext(sce.getServletContext());
        DefaultFtpServer defaultFtpServer = (DefaultFtpServer) webApplicationContext
                .getBean("ftpserver");
        sce.getServletContext()
                .setAttribute("FTPSERVER_CONTEXT_NAME", defaultFtpServer);
        try {
            defaultFtpServer.start();
            System.out.println("=========================================");
        } catch (FtpException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DefaultFtpServer defaultFtpServer = (DefaultFtpServer) sce
                .getServletContext().getAttribute("FTPSERVER_CONTEXT_NAME");
        defaultFtpServer.stop();

    }
}
