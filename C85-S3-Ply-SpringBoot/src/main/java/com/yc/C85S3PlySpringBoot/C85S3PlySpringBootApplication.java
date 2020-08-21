package com.yc.C85S3PlySpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.C85S3PlySpringBoot.dao")
public class C85S3PlySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C85S3PlySpringBootApplication.class, args);
	}
	
	/*@Bean   可以定义Bean
	public XXXBiz getXxxBiz() {
		return new XXXBiz();
	}*/

}
