package com.yc.damai.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.yc.damai.bean.DmCategory;
import com.yc.damai.bean.DmOrderitem;
import com.yc.damai.bean.DmProduct;

public class MapperTest {
	
	private SqlSession session ;
	
	//动态块
	{
		try {
			// mybatis 配置文件
			String resource = "mybatis.xml";
			// 读入配置文件
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 构建会话工厂 ==> 23 设计模式 工厂模式
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 开启会话
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	// 测试方法必须加 test 注解
	@Test
	public void test1() throws IOException {
		// session.selectList("xml接口的命名空间 + 英文点号 + 查询的sql的id");
		List<DmProduct> list = session.selectList("com.yc.damai.dao.DmProductMapper.selectAll");
		/**
		 * 	使用断言进行结果的判断
		 *  true 表示的期望值
		 *  list.size()>0 是实际值
		 */
		Assert.assertEquals(true, list.size() > 0);
		for(DmProduct dp : list) {
			System.out.println(dp);
		}

	}
	
	@Test
	public void test2() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("测试分类");
		dc.setPid(1);
		// session.insert("com.yc.damai.dao.DmProductMapper.insert",dc);
		// 获取映射接口实现类 (核心技术) 动态代理(JDK)
		DmCategoryMapper mapper = session.getMapper(DmCategoryMapper.class);
		mapper.insert(dc);
		// 不commit, 会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test3() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setId(44);
		dc.setCname("修改后的测试分类");
		dc.setPid(1);
		//session.update("com.yc.damai.dao.DmProductMapper.update",dc);
		DmCategoryMapper mapper = session.getMapper(DmCategoryMapper.class);
		mapper.update(dc);
		// 不commit, 会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test4() throws IOException {
		/*DmCategory dc = new DmCategory();
		dc.setId(44);
		dc.setCname("修改后的测试分类");
		dc.setPid(1);*/
		//session.delete("com.yc.damai.dao.DmProductMapper.delete",dc);
		DmCategoryMapper mapper = session.getMapper(DmCategoryMapper.class);
		mapper.delete(44);
		// 不commit, 会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test5() throws IOException {
		/**
		 * 1. 先查出一个订单明细记录
		 * 2. 查出该订单明细对应的商品信息
		 */
		/*DmOrderitemMapper dom = session.getMapper(DmOrderitemMapper.class);
		DmProductMapper dpm = session.getMapper(DmProductMapper.class);
		DmOrderitem doi = dom.selectById(59);
		DmProduct dp = dpm.selectById(doi.getPid());*/
		
		/**
		 * 测试驱动开发  ==> 先写好所有的测试代码 ==> 再业务代码 
		 */
		DmOrderitemMapper dom = session.getMapper(DmOrderitemMapper.class);
		DmOrderitem doi = dom.selectById(59);
		// java黑科技  ==> 反射 ==> 动态代理技术
		DmProduct dp = doi.getDmProduct();  // 调用 dmProduct 属性的get方法
		
		System.out.println(dp);
		session.close();
	}

}
