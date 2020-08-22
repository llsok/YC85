package com.yc.C85S3PlySpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@MapperScan("com.yc.C85S3PlySpringBoot.dao")
// 开启定时任务
@EnableScheduling
public class C85S3PlySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C85S3PlySpringBootApplication.class, args);
	}
	
	/**
	 * 首先要注入ServerEndpointExporter，这个bean会自动注册使用了
	 * @ServerEndpoint注解声明的Websocket endpoint。要注意，
	 * 如果使用独立的servlet容器，而不是直接使用springboot的内置容器，
	 * 就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
	 * @return
	 */
	@Bean // 约定优于配置
	public ServerEndpointExporter serverEndpointExporter() { 
		return new ServerEndpointExporter(); 
	} 
	
	/*@Bean   可以定义Bean
	public XXXBiz getXxxBiz() {
		return new XXXBiz();
	}*/

}
