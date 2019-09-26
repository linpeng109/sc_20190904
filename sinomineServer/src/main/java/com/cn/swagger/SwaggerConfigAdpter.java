package com.cn.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigAdpter {

    @Bean
    public Docket createDocket() {
        Docket apis = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cn.web"))
                .paths(PathSelectors.any())
                .build();
        return apis;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SINOMINE网站系统API使用方法")
                .description("本文档描述SINOMINE网站系统API访问方法")
                .version("1.0")
                .build();
    }
}
