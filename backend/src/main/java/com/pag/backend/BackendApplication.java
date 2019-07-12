package com.pag.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rafael.tackla
 *
 */
@SpringBootApplication
@EnableSwagger2
public class BackendApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(apis())
					.paths(PathSelectors.any())
					.build()
				.apiInfo(apiInfo())
				.pathMapping("/");
	}
	
	private Predicate<RequestHandler> apis() {
		return RequestHandlerSelectors.basePackage("com.pag.backend.controller.rest");
	}
	
    private ApiInfo apiInfo() {
    	 
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("Desafio PAG backend REST API")
                .description ("Esta é a API Rest em JAVA do desafio quero ser paguer backend")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
 
        return apiInfo;
    }

}
