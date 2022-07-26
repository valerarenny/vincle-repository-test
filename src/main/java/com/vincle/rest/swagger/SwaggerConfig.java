package com.vincle.rest.swagger;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public static final String HEADER_PASS_AS = "header";
    public static final String GLOBAL_SCOPE = "global";
    public static final String API_CONTACT_NAME = "Renny Valera";
    public static final String API_CONTACT_URL = "";
    public static final String API_CONTACT_EMAIL = "valerarenny@gmail.com";
    public static final String API_DESCRIPTION = "API de items";
    public static final String API_TITLE = "Api Items";
    public static final String API_VERSION = "1.0.0";
    
    private final TypeResolver typeResolver;

    public SwaggerConfig(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
	        		.select()
	        		.apis(RequestHandlerSelectors.basePackage("com.vincle.rest.controller"))
	        		.paths(PathSelectors.any())
	        		.build()
	        		.apiInfo(buildApiInfo())
	        		.pathMapping("/");
//                .select()
//                .apis(
//                        RequestHandlerSelectors.withClassAnnotation(RestController.class)
//                )
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(buildApiInfo())
//                .securityContexts(List.of(securityContext()))
//                .securitySchemes(Arrays.asList(apiKeySecurityScheme(), authorizedUserScheme()));
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact(API_CONTACT_NAME, API_CONTACT_URL, API_CONTACT_EMAIL))
                .description(API_DESCRIPTION)
                .title(API_TITLE)
                .version(API_VERSION)
                .build();
    }

  

}
