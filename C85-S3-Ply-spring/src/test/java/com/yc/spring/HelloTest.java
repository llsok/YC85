package com.yc.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
	
	@Test
	public void test() {
		// Hello h = new Hello();
		
		// 从 Spring 框架(容器)中获取一个 Hello 对象
		// 创建Spring容器对象
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beans.xml");
	
		Hello h = (Hello) ctx.getBean("hello");
		
		// 执行 sayHello 方法
		h.sayHello();
		
		ctx.close();
		
	}

}
