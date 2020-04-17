package com.yc.library.dao;

import java.util.List;

import org.junit.Test;

import com.yc.library.bean.Lend;
import com.yc.library.util.DBHelper;

public class LendTest {
	
	@Test
	public void test() {
		
		// 不带参数的创建DBHelper, 是自动提交
		DBHelper dbh = new DBHelper();
		
		List<Lend> list = dbh.query("select * from lend", Lend.class);
	
		for(Lend l : list) {
			System.out.println(l);
		}
		
	}

}
