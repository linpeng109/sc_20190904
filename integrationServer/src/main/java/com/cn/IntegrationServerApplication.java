package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@ImportResource(locations = {
        "classpath:spring-integration.xml",
        "classpath:spring-integration-kafka.xml"})
public class IntegrationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegrationServerApplication.class, args);
    }
}
