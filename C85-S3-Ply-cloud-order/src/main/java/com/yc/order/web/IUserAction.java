package com.yc.order.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="user") // 网元名称 服务名
public interface IUserAction {
	@GetMapping("user")// 对应是 action的地址
	public String user();
}
