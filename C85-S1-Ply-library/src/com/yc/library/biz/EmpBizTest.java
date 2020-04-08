package com.yc.library.biz;

import org.junit.Assert;
import org.junit.Test;

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
