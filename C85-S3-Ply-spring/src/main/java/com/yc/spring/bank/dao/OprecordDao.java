package com.yc.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.bean.Oprecord;

/**
 * 银行操作流水表 Dao
 */
@Repository
public class OprecordDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 添加流水记录
	 * @param id
	 * @param money
	 * @return
	 */
	public int insert(int id, double money) {
		return jdbcTemplate.update("insert into oprecord values(null,?,?,null,now())", id, money);
	}

	public List<Oprecord> selectById(int accountid) {
		String sql = "select * from oprecord where accountid = ?";
		Object[] args = { accountid };

		return jdbcTemplate.query(sql, args, new RowMapper<Oprecord>() {

			public Oprecord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Oprecord o = new Oprecord();
				o.setId(rs.getInt("id"));
				o.setAccountid(rs.getInt("accountid"));
				o.setOpmoney(rs.getDouble("opmoney"));
				o.setCharge(rs.getDouble("charge"));
				o.setOptime(rs.getTimestamp("optime"));
				return o;
			}
		});

	}

}
