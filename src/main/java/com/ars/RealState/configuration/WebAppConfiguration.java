package com.ars.RealState.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.ars.RealState")
public class WebAppConfiguration implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("/assets/")
				.setCachePeriod(6000);
		
		registry.addResourceHandler("/property_image/**")
		.addResourceLocations("file:///C://Users//imani//Desktop/image/property_image/")
		.setCachePeriod(3600);
		
		registry.addResourceHandler("/agent_image/**")
		.addResourceLocations("file:///C://Users//imani//Desktop/image/agent_images/")
		.setCachePeriod(3600);

	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
	CommonsMultipartResolver mr = new CommonsMultipartResolver();
	mr.setMaxUploadSize(500000000L);
	 return mr;}
}
