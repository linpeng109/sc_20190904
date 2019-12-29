package com.cn.ftpserver;

import lombok.extern.log4j.Log4j2;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
@WebListener
public class FtpServerServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils
                .getWebApplicationContext(sce.getServletContext());
        DefaultFtpServer defaultFtpServer = (DefaultFtpServer) webApplicationContext
                .getBean("fptserver");
        sce.getServletContext()
                .setAttribute("FTPSERVER_CONTEXT_NAME", defaultFtpServer);
        try {
            defaultFtpServer.start();
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
