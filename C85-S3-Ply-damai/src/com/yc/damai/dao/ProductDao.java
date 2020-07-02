package com.yc.damai.dao;

import java.util.List;
import java.util.Map;

import com.yc.damai.util.DBHelper;

public class ProductDao {
	
	public List<Map<String,Object>> query1(String page, String rows){
		int ipage = Integer.parseInt(page);
		int irows = Integer.parseInt(rows);
		ipage = (ipage - 1) * 10;
		String sql = "select a.*, b.cname from dm_product a"
				+ " join dm_category b on a.cid = b.id"
				+ " limit ?, ?";
		return new DBHelper().query(sql, ipage, irows);
	}
	
	public int count1(){
		String sql = "select count(*) from dm_product";
		return new DBHelper().count(sql);
	}

}
