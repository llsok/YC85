package com.yc.library.dao;

import java.util.*;

import com.yc.library.bean.Book;
import com.yc.library.util.DBHelper;

public class BookDao {
	
	/**
	 * 	添加图书
	 * @param book
	 */
	public int insert(Book book) {
		String sql = "insert into book values(seq_book_id.nextval,?,?,?,?,?,?)";
		return new DBHelper().update(sql, 
				book.getName(),
				book.getAuthor(),
				book.getIsbn(),
				book.getPress(),
				book.getPressdate(),
				book.getStatus());
	}
	
	public List<Map<String,Object>> selectAll() {
		String sql = "select * from book";
		return new DBHelper().query(sql);
	}
	
	public List<Book> selectAll1() {
		String sql = "select * from book";
		return new DBHelper().query(sql, Book.class);
	}

}
