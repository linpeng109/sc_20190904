package com.cn.ftp;

import lombok.extern.log4j.Log4j2;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@Log4j2
@WebListener
public class FtpServerManagerServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug(sce.getServletContext().getServerInfo() + "......START......");
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        FtpServerManager ftpServerManager = (FtpServerManager) webApplicationContext.getBean("ftpServerManager");
        try {
            FtpServer ftpServer = ftpServerManager.create();
            ftpServer.start();
            log.debug("FtpServer is stopped ? " + ftpServer.isStopped());
            sce.getServletContext().setAttribute("ftpServer", ftpServer);
        } catch (IOException | FtpException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.debug(sce.getServletContext().getServerInfo() + "......END......");
        FtpServer ftpServer = (FtpServer) sce.getServletContext().getAttribute("ftpServer");
        ftpServer.stop();

    }

}
