package com.yc.library.biz;

import java.util.List;

import com.yc.library.bean.Emp;
import com.yc.library.util.DBHelper;

/**
 * 	图书管理员的业务类
 * @author 廖彦
 *
 */
public class EmpBiz {
	
	/**
	 * 	员工登录的方法, 只用自定义异常返回报错信息
	 * @param account 账号
	 * @param pwd	  密码
	 * @return
	 * @throws BizException 
	 */
	public boolean login(String account, String pwd) throws BizException {
		
		// 如果 account == null  或  空字符串  应该提示用户请输入用户名
		// 如果 pwd == null  或  空字符串  应该提示用户请输入密码
		// 如果登录失败, 应该提示用户名或密码错误
		
		if(account==null || account.trim().isEmpty() ) {
			throw new BizException("请输入用户名 ! ");
		}
		
		if(pwd==null || pwd.trim().isEmpty() ) {
			throw new BizException("请输入密码! ");
		}
		
		// 需要基本的判断
		String sql = "select * from emp where account=? and pwd=?";
		List<Emp> list = new DBHelper().query(sql, Emp.class, account, pwd);
		if(list.size() == 1) {
			return true;
		} else {
			throw new BizException("用户名或密码错误 ! ");
		}
	}

}
