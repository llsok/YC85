package com.yc.library.biz;

import org.junit.Assert;
import org.junit.Test;

/**
 * 	insertBook 主键冲突  主键生成机制
 * 
 * 	图书借阅的业务逻辑: JDBC事务管理
 * 		业务逻辑比较复杂, 涉及2个表的操作
 * 		1. lend ==> 记录借阅信息, 借阅人, 借阅时间, 图书id ...
 * 		2. book ==> 借阅状态由 0 变 1;
 * 		
 * 
 * 	借阅管理的界面
 *
 */
public class EmpBizTest {
	
	@Test
	public void testLogin() {
		EmpBiz ebiz = new EmpBiz();
		
		try {
			boolean ret = ebiz.login("admin", "123");
			Assert.assertTrue(ret);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		try {
			ebiz.login("admin", "456");
			Assert.fail("代码不应该走到这里!");
		} catch (BizException e) {
			Assert.assertEquals("用户名或密码错误 ! ", e.getMessage());
		}
		
		try {
			ebiz.login("root", "123");
			Assert.fail("代码不应该走到这里!");
		} catch (BizException e) {
			Assert.assertEquals("用户名或密码错误 ! ", e.getMessage());
		}
		
		try {
			ebiz.login("", "123");
			Assert.fail("代码不应该走到这里!");
		} catch (BizException e) {
			Assert.assertEquals("请输入用户名 ! ", e.getMessage());
		}
		
		try {
			ebiz.login(null, "123");
			Assert.fail("代码不应该走到这里!");
		} catch (BizException e) {
			Assert.assertEquals("请输入用户名 ! ", e.getMessage());
		}
		
		try {
			ebiz.login("admin", "");
			Assert.fail("代码不应该走到这里!");
		} catch (BizException e) {
			Assert.assertEquals("请输入密码! ", e.getMessage());
		}
		
		try {
			ebiz.login("admin", null);
			Assert.fail("代码不应该走到这里!");
		} catch (BizException e) {
			Assert.assertEquals("请输入密码! ", e.getMessage());
		}
		
		
	}

}
