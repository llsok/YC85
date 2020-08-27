package com.yc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OrderApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	/**
	 * 	定义 RestTemplate  Bean
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


}
