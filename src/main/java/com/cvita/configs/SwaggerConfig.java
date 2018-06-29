package com.cvita.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("CVITA-API")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cvita.controllers"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo(){
		return new ApiInfo(
				"CVITA API",
				"com.CVITA API reference for developers",
				"0.0.1",
				"http://localhost:3388",
				new Contact("Chatita", "http://localhost:3388", "kos91q@gmail.com"),
				"License",
				"LicenseUrl",
				Collections.emptyList()
		);
	}
}