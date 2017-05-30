package com.expense.master.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
// http://localhost:8080/swagger-ui.html
public class SwaggerConfig {

	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(paths())
				.build().apiInfo(metadata());
	}

	private Predicate<String> paths() {
		Predicate<String> or = regex("/service.*");
		return or;
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Expense Service")
				.description("Microservice to create a Expense of a day").version("1.0")
				.contact("sidhu.c1988@gmail.com").build();
	}

	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl");
	}

}