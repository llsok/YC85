package com.yc.crbook;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.crbook.bean.CrUser;
import com.yc.crbook.bean.CrUserExample;
import com.yc.crbook.dao.CrUserMapper;

@SpringBootTest
class ApplicationTests {
	
	@Resource
	CrUserMapper uMapper;

	@Test
	void contextLoads() {
		
		// MyBatis 方向工程的接口的使用
		
		// 组合条件查询 <if>  ==> Example 对象构建条件
		
		CrUserExample ue = new CrUserExample();
		// == where account='zhangsan' and pwd='111'
		ue.createCriteria()
			.andAccountEqualTo("admin")
			.andPwdEqualTo("111");
		
		List<CrUser> list = uMapper.selectByExample(ue);
		
		Assert.assertEquals(1, list.size());
		
	}

}
