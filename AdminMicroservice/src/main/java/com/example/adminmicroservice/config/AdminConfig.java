package com.example.adminmicroservice.config;

import com.example.adminmicroservice.errordecoder.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AdminConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.adminmicroservice"))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}
}
