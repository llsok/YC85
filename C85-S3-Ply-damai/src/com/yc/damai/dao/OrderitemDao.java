package com.yc.damai.dao;

import com.yc.damai.util.DBHelper;

public class OrderitemDao {
	
	/**
	 * 	添加订单明细记录
	 * @param uid
	 */
	public int insert(String uid) {
		// -- LAST_INSERT_ID() 获取最近产生的主键值( 自增列 )
		String sql = "INSERT INTO dm_orderitem SELECT\n" +
				"	NULL,\n" +
				"	a.count,\n" +
				"	a.count * b.shop_price,\n" +
				"	a.pid,\n" +
				"	LAST_INSERT_ID()\n" +
				"FROM\n" +
				"	dm_cart a\n" +
				"JOIN dm_product b ON a.pid = b.id\n" +
				"WHERE\n" +
				"	uid = ?";
		return new DBHelper().update(sql, uid);
	}
	

}
