package com.yc.damai.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yc.damai.bean.DmProduct;

public class DmProductMapperTest {

	public static void main(String[] args) throws IOException {
		// mybatis 配置文件
		String resource = "mybatis.xml";
		// 读入配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 构建会话工厂  ==>  23 设计模式   工厂模式
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 开启会话
		SqlSession session = sqlSessionFactory.openSession();
		
		
		//session.selectList("xml接口的命名空间 +   英文点号  +  查询的sql的id");
		List<DmProduct> list = session.selectList(
				"com.yc.damai.dao.DmProductMapper.selectAll");
		
		for(DmProduct dp : list) {
			System.out.println(dp);
		}
		
	}
	
}
