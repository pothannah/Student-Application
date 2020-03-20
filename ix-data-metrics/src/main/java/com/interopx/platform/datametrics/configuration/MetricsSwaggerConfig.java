package com.interopx.platform.datametrics.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The Class AuditSwaggerConfig swagger configuration
 */
@Configuration
@EnableSwagger2
public class MetricsSwaggerConfig {                                    

	private static final Logger LOGGER = LoggerFactory.getLogger(MetricsSwaggerConfig.class);
	/**
	 * Api for swagger
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {     
		LOGGER.info("Entry - Docket API for swagger");
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("X-AUTH-TOKEN")                 // name of header
			.modelRef(new ModelRef("string"))
			.parameterType("header")               // type - header
			.defaultValue("")        // based64 of - zone:mypassword
			.required(true)                // for compulsory
			.build();
		List<Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder.build());
		LOGGER.info("Exit - Docket API for swagger");
		return new Docket(DocumentationType.SWAGGER_2)          
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Controller.class))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo())
				.pathMapping("")
				.globalOperationParameters(aParameters);
	}


	/**
	 * Api info to pass to swagger
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		LOGGER.info("Entry -  API info for swagger");
		ApiInfo apiInfo = new ApiInfo(
				"InteropX Data Metrics Service",
				"Metrics service",
				"1.0",
				"Terms of service",
				new Contact("InteropX", "http://interopx.com/", "info@interopx.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());
		LOGGER.info("Exit -  API info for swagger");
		return apiInfo;
	}
}
