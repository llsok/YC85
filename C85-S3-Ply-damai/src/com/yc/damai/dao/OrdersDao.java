package com.yc.damai.dao;

import com.yc.damai.util.DBHelper;

public class OrdersDao {
	
	public int insert(String uid) {
		String sql = 
		"INSERT INTO dm_orders SELECT\n" +
				"	NULL,\n" +
				"	c.total,\n" +
				"	now(),\n" +
				"	0,\n" +
				"	a.id,\n" +
				"	b.id\n" +
				"FROM\n" +
				"	dm_user a\n" +
					// 获取默认地址 
				"JOIN dm_address b ON a.id = b.uid\n" +
				"AND dft = 1\n" +
				"JOIN (\n" +
					// 求订单总金额
				"	SELECT\n" +
				"		sum(b.shop_price * a.count) total,\n" +
				"		a.uid\n" +
				"	FROM\n" +
				"		dm_cart a\n" +
				"	JOIN dm_product b ON a.pid = b.id\n" +
				"	WHERE\n" +
				"		a.uid = ?\n" +
				"	GROUP BY\n" +
				"		a.uid\n" +
				") c ON a.id = c.uid\n" +
				"WHERE\n" +
				"	a.id = ?";
		return new DBHelper().update(sql, uid, uid);
	}
	
	public static void main(String[] args) {
		
		new OrdersDao().insert("2");
		
	}

}
