package com.cn;

import com.cn.ftpserver.FtpServerServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableSwagger2
@Configuration
@ImportResource(locations = {"classpath:ftpserver.xml"})
public class FtpServerApplication implements ServletContextInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FtpServerApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(FtpServerServletContextListener.class);
    }
}
