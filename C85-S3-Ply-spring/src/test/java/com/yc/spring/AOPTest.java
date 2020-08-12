package com.yc.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.MySQLUserDao;
import com.yc.spring.dao.OracleUserDao;
import com.yc.spring.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPTest {
	
	@Autowired
	@Qualifier("mdao") // 指定注入的组件的id, 
	private UserDao mdao;
	@Autowired
	@Qualifier("odao")
	private UserDao odao;
	@Autowired
	private Person person;
	@Autowired
	private Hello hello;
	
	@Test
	public void test1() {
		System.out.println("======1=======");
		odao.selectUserId("");
		System.out.println("======2=======");
		mdao.selectUserId("");
		System.out.println("======3=======");
	}
	
	@Test
	public void test2() {
		/**
		 * Bean named 'mdao' is expected to be of type 
		 * 'com.yc.spring.dao.MySQLUserDao' but was actually 
		 * of type 'com.sun.proxy.$Proxy39'
		 */
		System.out.println(mdao);	// JDK 代理命名规则 $Proxy
		System.out.println(odao);	// JDK
		System.out.println(person);
		System.out.println(hello); // CGLIB debug 模式才能看到: 名字中带了 CGLIB
	}
	
	
	

}
