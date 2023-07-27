package com.hacker.news.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc // for enable swagger 
public class SwaggerApiTest {

	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
		
	}

	private ApiInfo getInfo() {
		
		return new ApiInfo("Haker News API ", "Spring Boot Haker News Demo Project", "1.0", "Term of condition",
				new Contact("Pritam Rajput", "https://pritamrajput.wordpress.com/", "pritamrajput1906@gmail.com"),
		          		"License of APIS", "API license URL", Collections.emptyList());
	}
}
