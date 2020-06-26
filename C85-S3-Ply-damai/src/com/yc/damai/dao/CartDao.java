package com.yc.damai.dao;

import com.yc.damai.util.DBHelper;

public class CartDao {

	/**
	 * 	给某用户添加新的购物车商品
	 * @param uid
	 * @param pid
	 * @return 新增的记录数
	 */
	public int insert(String uid, String pid) {
		String sql = "insert into dm_cart values(null,?,?,1)";
		return new DBHelper().update(sql, uid, pid);
	}
	
	/**
	 * 	给某个用户的购物车商品数量 + 1
	 * @param uid
	 * @param pid
	 * @return  更新的记录数
	 */
	public int update(String uid, String pid) {
		String sql = "update dm_cart set count=count + 1 where uid=? and pid=?";
		return new DBHelper().update(sql, uid, pid);
	}
	
	
}
