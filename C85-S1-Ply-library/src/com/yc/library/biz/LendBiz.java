package com.yc.library.biz;

import com.yc.library.util.DBHelper;

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
		
		/**
		 * 判断该图书是否已经被借阅出去了
		 */
		
		DBHelper dbh = new DBHelper();
		String sql = "insert into lend values(seq_book_id.nextval,?,?,sysdate,null,null,?)";
		dbh.update(sql, bookid, person, eid);
		sql = "update book set status=1 where id=?";
		dbh.update(sql, bookid);
	}

}
