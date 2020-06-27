package com.yc.damai.dao;

import com.yc.damai.util.DBHelper;

public class OrdersDao {
	
	// 添加订单主表记录 orders
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
		// 这种写法有数据库事务的问题
		new OrdersDao().insert("2");
		// 出现异常, 会导致 订单被创建, 而订单明细没有创建, 购物车没有被清空
		new OrderitemDao().insert("2");
		new CartDao().deleteByUid("2");
	}

}
