package com.interopx.platform.datametrics;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


/**
 * The Class IxAuditApplication.
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//@EnableDiscoveryClient
//@EnableJpaAuditing
@ComponentScan(basePackages = { "com.interopx.platform.datametrics" })
public class IxDataMetricsApplication extends SpringBootServletInitializer {


	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(IxDataMetricsApplication.class);


	/**
	 * To start the Spring Application .
	 *
	 * @param springapplicationbuilder the springapplicationbuilder
	 * @return SpringApplicationBuilder
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springapplicationbuilder) {
		return springapplicationbuilder.sources(IxDataMetricsApplication.class);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(IxDataMetricsApplication.class, args);
	}

	/**
	 * Adds the resource handlers.
	 *
	 * @param registry the registry
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
