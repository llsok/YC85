package com.yc.library.biz;

import org.junit.Assert;
import org.junit.Test;

public class LendBizTest {
	
	@Test
	public void testLend() {
		LendBiz lbiz = new LendBiz();
		try {
			lbiz.lend(1L, "吴用", 1L);
		} catch (BizException e) {
			e.printStackTrace();
			Assert.fail("代码不应该走到这里!");
		}
	}

}
