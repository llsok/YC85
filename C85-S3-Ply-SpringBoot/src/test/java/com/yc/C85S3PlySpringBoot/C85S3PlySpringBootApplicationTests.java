package com.yc.C85S3PlySpringBoot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.C85S3PlySpringBoot.biz.MailService;
import com.yc.C85S3PlySpringBoot.dao.ProductMapper;

@SpringBootTest
class C85S3PlySpringBootApplicationTests {

	@Resource
	ProductMapper pm;
	
	@Resource
	MailService ms;

	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size() > 0, "没有数据");
	}
	
	@Test
	void testMail() {
		ms.sendSimpleMail("306529917@qq.com", "密码重置验证码", "您重置密码的验证码是: 123456");
	}

}
