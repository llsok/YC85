package com.yc.C85S3Plyblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C85S3Plyblog.bean.User;
import com.yc.C85S3Plyblog.dao.UserMapper;

@Service
public class UserBiz {

	@Resource
	private UserMapper uMapper;

	public void register(User user) throws BizException {
		// 可以忽略字段验证
		// 同名验证
		if (uMapper.countByAccount(user.getAccount()) > 0) {
			throw new BizException("该用户已经存在!");
		}
		uMapper.insert(user);
	}

	public User login(User user) throws BizException {
		// 可以忽略字段验证
		// 同名验证
		User dbuser = uMapper.selectByLogin(user);
		if (dbuser == null) {
			throw new BizException("用户名或密码错误!");
		}
		return dbuser;
	}

}
