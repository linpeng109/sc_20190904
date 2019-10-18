package com.cn.ftp;

import lombok.extern.log4j.Log4j2;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.*;
import org.apache.ftpserver.listener.ListenerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@WebListener
public class FtpServerManagerServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug(sce.getServletContext().getServerInfo() + "......START......");
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        // set the port of the listener
        factory.setPort(2221);
        // replace the default listener
        serverFactory.addListener("default", factory.createListener());
        // start the server
        Map<String, Ftplet> ftplets = new HashMap<>();
        Ftplet ftplet = new Ftplet() {
            @Override
            public void init(FtpletContext ftpletContext) throws FtpException {

            }

            @Override
            public void destroy() {

            }

            @Override
            public FtpletResult beforeCommand(FtpSession ftpSession, FtpRequest ftpRequest) throws FtpException, IOException {
                return null;
            }

            @Override
            public FtpletResult afterCommand(FtpSession ftpSession, FtpRequest ftpRequest, FtpReply ftpReply) throws FtpException, IOException {
                return null;
            }

            @Override
            public FtpletResult onConnect(FtpSession ftpSession) throws FtpException, IOException {
                return null;
            }

            @Override
            public FtpletResult onDisconnect(FtpSession ftpSession) throws FtpException, IOException {
                return null;
            }
        };
        ftplets.put("default", ftplet);
        serverFactory.setFtplets(ftplets);
        FtpServer server = serverFactory.createServer();
        try {
            server.start();
        } catch (FtpException e) {
            e.printStackTrace();
        }
//        =====================================================================
//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//        FtpServerManager ftpServerManager = (FtpServerManager) webApplicationContext.getBean("ftpServerManager");
//
//        try {
//            FtpServer ftpServer = ftpServerManager.create();
//            ftpServer.start();
//            log.debug("FtpServer is running ? " + !ftpServer.isStopped());
//            sce.getServletContext().setAttribute("ftpServer", ftpServer);
//        } catch (IOException | FtpException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.debug(sce.getServletContext().getServerInfo() + "......END......");
//        FtpServer ftpServer = (FtpServer) sce.getServletContext().getAttribute("ftpServer");
//        ftpServer.stop();

    }

}
