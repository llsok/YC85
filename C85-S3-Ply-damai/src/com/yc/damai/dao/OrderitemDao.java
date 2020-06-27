package com.yc.damai.dao;

import java.util.List;
import java.util.Map;

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
				// 使用子查询获取到当前新增的订单id
				"	(select max(id) from dm_orders )\n" + 
				"FROM\n" +
				"	dm_cart a\n" +
				"JOIN dm_product b ON a.pid = b.id\n" +
				"WHERE\n" +
				"	uid = ?";
		return new DBHelper().update(sql, uid);
	}
	
	public List<?> queryByOid(String oid) {
		String sql = "select * from dm_orderitem a join dm_product b on a.pid=b.id"
				+ " where oid=?";
		return new DBHelper().query(sql, oid);
	}
	

}
