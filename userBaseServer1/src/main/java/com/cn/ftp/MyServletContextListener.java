package com.cn.ftp;

import org.apache.ftpserver.FtpServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());

        FtpServer server = (FtpServer) ctx.getBean("MyFtp");
        sce.getServletContext().setAttribute(Constants.SERVER_NAME, server);
        try {
            server.();
            server.start();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("FTP启动失败", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        MyFtpServer server = (MyFtpServer) ctx.getServletContext().getAttribute(Constants.SERVER_NAME);
        server.stop();
        sce.getServletContext().removeAttribute(Constants.SERVER_NAME);
    }
}
