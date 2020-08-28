package com.yc.order.web;

import org.springframework.stereotype.Component;

@Component
public class UserActionHytrix implements IUserAction{

	@Override
	public String user() {
		return "声明式的user服务接口降级回复信息";
	}

}
