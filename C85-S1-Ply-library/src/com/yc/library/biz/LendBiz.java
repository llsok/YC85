package com.yc.library.biz;

import java.sql.SQLException;

import com.yc.library.util.DBHelper;

/**
 * 假设 数据库并没有安装在我的本机上, 通过网络连接数据库, 那么有可能会出现断连问题
 * 
 * 事务四大特性:
 * 1.原子性
 * 2.一致性
 * 3.隔离性
 * 4.持久性
 * 
 * 在同一个数据库的事务中执行  insert 和 update
 * 统一个事务基于同一个连接
 * 
 * try{
 * 		把所有事务相关的代码写在这里
 * 		如果业务代码执行成功, 那么就提交事务: 执行连接的 commit方法
 * } catch () {
 * 		如果业务代码执行失败, 那么就回滚事务:  执行连接的 rollback方法
 * } finally {
 * 		不管是成功还是失败, 都必须关闭连接
 * }
 * 
 */
public class LendBiz {

	/**
	 * 借书方法
	 * @param bookid	图书id	:  系统内部数据
	 * @param person	借阅人	:  输入的信息     加以判断
	 * @param eid		经办人( 员工id ):  系统内部数据
	 * @throws BizException 
	 */
	public void lend(Long bookid, String person, Long eid) throws BizException {
		if (person == null || person.trim().isEmpty()) {
			throw new BizException("请输入借阅人姓名!");
		}
		if (person.trim().length() < 2) {
			throw new BizException("请输入完整的借阅人姓名!");
		}
		DBHelper dbh = new DBHelper();
		/**
		 * 判断该图书是否已经被借阅出去了
		 * nvl( 值, 默认值 ) 判断值是否为空, 如果为null 返回 后面的默认值, 不为空则返回原值
		 * null value else
		 */
		try {
			String sql = "select * from book where id=? and nvl(status, 0) = 0 ";
			int count = dbh.count(sql, bookid);
			if(count == 0) {
				throw new BizException("该图书已经被借出!");
			}
			// 添加借阅记录
			sql = "insert into lend values(seq_book_id.nextval,?,?,sysdate,null,null,?)";
			dbh.update(sql, bookid, person, eid);
			
			// int i = 1/0;
			
			// 更新图书借阅状态
			sql = "update book set status=1 where id=?";
			dbh.update(sql, bookid);
			// 提交
			dbh.getConn().commit();
		} catch (Exception e) {
			// 回滚
			try {
				dbh.getConn().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			dbh.closeConnection();
		}
	}

}
