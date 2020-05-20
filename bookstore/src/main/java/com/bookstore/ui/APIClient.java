package com.bookstore.ui;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan( basePackages = { 
							"com.bookstore.controller",
							"com.bookstore.bean",
							"com.bookstore.service",
							"com.bookstore.dao",
							"com.bookstore.ui",
							"configuration"})
public class APIClient {
	
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(APIClient.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.ant("/api/*"))
					.build();
	}

}