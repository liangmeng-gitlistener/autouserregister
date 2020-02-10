package com.gtzz.autouserregister.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
//  http://127.0.0.1:8080/swagger-ui.html
public class SwaggerConfig {

    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //  是否开启
                .enable(swaggerEnabled).select()
                //  扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.gtzz.autouserregister.controller"))
                //  指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("向工投智造平台自动化注册用户信息")
                .description("desc")
                .contact(new Contact("gtzz", "https://www.gziiim.com/", "gtzz@gziiim.com"))
                .version("1.0.0")
                .build();
    }
}
