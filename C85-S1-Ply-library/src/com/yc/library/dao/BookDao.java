package com.yc.library.dao;

import com.yc.library.bean.Book;
import com.yc.library.util.DBHelper;

public class BookDao {
	
	/**
	 * 	添加图书
	 * @param book
	 */
	public int insert(Book book) {
		String sql = "insert into book values(?,?,?,?,?,?,?)";
		return new DBHelper().update(sql, 
				book.getId(),
				book.getName(),
				book.getAuthor(),
				book.getIsbn(),
				book.getPress(),
				book.getPressdate(),
				book.getStatus());
	}

}
