package com.yc.web.d0604;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.web.util.DBHelper;

public class BookDao {
	
	public List<Map<String,Object>> query(){
		DBHelper dbh = new DBHelper();
		String sql = "select * from books";
		return dbh.query(sql);
	}
	
	public List<Map<String,Object>> query(String name, String press, String date){
		DBHelper dbh = new DBHelper();
		String sql = "select * from books where 1=1";
		List<Object> params = new ArrayList<>();
		if(name!=null && name.trim().isEmpty()==false) {
			sql += " and bookname like concat('%', ? ,'%')";
			params.add(name);
		}
		if(press!=null && press.trim().isEmpty()==false) {
			sql += " and bookpress like concat('%', ? ,'%')";
			params.add(press);
		}
		if(date!=null && date.trim().isEmpty()==false) {
			// 2020-10-10
			Date d = Date.valueOf(date);
			sql += " and bookdate = ?";
			params.add(d);
		}
		return dbh.query(sql, params.toArray());
	}

}
