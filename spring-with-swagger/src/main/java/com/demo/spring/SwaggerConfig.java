package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses=GreetController.class)
public class SwaggerConfig {

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.license("Apache 2.0 License")
				.description("A Demo Application")
				.title("Greeter App")
				.build();
	}
	
	//very iportant part of swagger configuration
	//if not written correctly, operations will not be detected at all
	//
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.spring"))
                .paths(PathSelectors.regex("/app.*"))
                .build()
                .apiInfo(apiInfo());
	}
}
