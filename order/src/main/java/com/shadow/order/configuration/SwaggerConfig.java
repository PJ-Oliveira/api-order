package com.shadow.order.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shadow.order"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
    	return new ApiInfoBuilder()
    			.title("Projeto Shadow")
    			.description("Microservice Order")
    			.version("1.0")
    			.license("Apache License Version 2.0")
    			.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0/")
    			.contact(new Contact("Info Contato", "Site Contato", "email contato"))
    			.build();
    }
}
