package com.yc.web.d0524;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener, ServletContextAttributeListener {

	/**
	 * ServletContextAttributeListener
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
		// 添加属性值
		System.out.println(event.getName() + "======attributeAdded=======" + event.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		// 移除属性值
		System.out.println(event.getName() + "======attributeRemoved=======" + event.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		// 替换属性
		System.out.println(event.getName() + "======attributeReplaced=======" + event.getValue());
	}
	
	
	/**
	 * ServletContextListener
	 */
	public void contextInitialized(ServletContextEvent event) {
		// 初始化上下文对象
		System.out.println("============contextInitialized==========");
	}

	public void contextDestroyed(ServletContextEvent event) {
		// 销毁上下文对象
		System.out.println("============contextDestroyed==========");
	}

}
