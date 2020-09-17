package com.yc.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.crbook.bean.CrUser;
import com.yc.crbook.bean.CrUserExample;
import com.yc.crbook.bean.Result;
import com.yc.crbook.dao.CrUserMapper;

@RestController
@RequestMapping("user")
public class UserAction {

	@Resource
	private CrUserMapper uMapper;

	@PostMapping("login")
	public Result login(@RequestBody CrUser user) {
		CrUserExample cue = new CrUserExample();
		cue.createCriteria().andAccountEqualTo(user.getAccount()).andPwdEqualTo(user.getPwd());
		List<CrUser> list = uMapper.selectByExample(cue);
		if (list.isEmpty()) {
			return new Result(0, "用户名或密码错误！");
		} else {
			// 将登陆成功的用户对象返回
			return new Result(1, "登录成功！", list.get(0));
		}
	}
	
	@PostMapping("register")
	public Result register(@RequestBody CrUser user) {
		// 带 Selective 的insert 是动态生成 字段, 非 null 字段才会参与 insert
		// insert into 表名 values ( 所有的字段值 )
		uMapper.insertSelective(user);
		return new Result(1, "注册成功!", user);
	}
}
