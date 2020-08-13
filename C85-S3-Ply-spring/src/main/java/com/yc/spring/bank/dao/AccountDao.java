package com.yc.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.bean.Account;

/**
 *	银行账号Dao
 */
@Repository
public class AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(int id, String pwd, double money) {
		return jdbcTemplate.update("insert into account values(?,?,?)", id, pwd, money);
	}

	public int update(int id, double money) {
		return jdbcTemplate.update("update account set balance = balance + ? where accountid=?",
				money, id);
	}

	public Account selectById(int id) {
		String sql = "select * from account where accountid=?";
		Object[] args = { id };
		// ResultSetExtractor 是回调接口 , 用于将结果集中的数据转换成功 Account 对象
		return jdbcTemplate.query(sql, args, new ResultSetExtractor<Account>() {

			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				Account acc = new Account();
				acc.setAccountid(rs.getInt("accountid"));
				acc.setPassword(rs.getString("password"));
				acc.setBalance(rs.getDouble("balance"));
				return acc;
			}

		});
	}

}
