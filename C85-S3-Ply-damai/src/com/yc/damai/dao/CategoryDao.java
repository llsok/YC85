package com.yc.damai.dao;

import java.util.List;

import com.yc.damai.util.DBHelper;

public class CategoryDao {
	
	public List<?> query() {
		return new DBHelper().query("select * from dm_category");
		
	}

}
