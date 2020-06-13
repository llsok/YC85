package com.yc.web.d0613;

import java.util.List;

import com.yc.web.util.DBHelper;

public class PushBoxDao {

	public void save(String name, String game, String level, String data) {
		DBHelper dbh = new DBHelper();
		String sql = "update game_score set level=?, data=?"
				+ " where name=? and game=?";
		int ret = dbh.update(sql, level, data, name, game);
		// 判断是否更新到了玩家的记录 =1 表示有更新到
		if(ret == 0) {
			sql = "insert into game_score values("
					+ "null,null,?,?,?,null,?,now())";
			dbh.update(sql, name, game, level, data);
		}
	}
	
	public GameScore load(String name, String game) {
		String sql = "select * from game_score where name=? and game=?";
		List<GameScore> list = new DBHelper().query(sql, 
				GameScore.class, name, game);
		if(list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
		
	}

}
