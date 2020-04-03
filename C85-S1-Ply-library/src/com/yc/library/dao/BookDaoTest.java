package com.yc.library.dao;

import org.junit.Assert;
import org.junit.Test;

import com.yc.library.bean.Book;

/**
 * 	单元测试类 ,用于测试  BookDao
 * @author 廖彦
 *
 */
public class BookDaoTest {
	
	/**
	 * 	单元测试方法, 要求不能带任何参数
	 * 
	 * 	在该方法上必须加入  Test 注解, 给程序看的 注释
	 */
	@Test
	public void testInsert() {
		// 创建dao对象
		BookDao bDao = new BookDao();
		Book book = new Book();
		
		book.setId(1L);
		book.setName("Java编程思想");
		
		int cnt = bDao.insert(book);
		
		// 断言类
		Assert.assertEquals(1, cnt);
	}

}
