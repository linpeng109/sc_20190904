package com.cn;

import com.cn.ftp.FtpServerManagerServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableSwagger2
public class UserBaseServerApplication implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserBaseServerApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(FtpServerManagerServletContextListener.class);
    }


}
