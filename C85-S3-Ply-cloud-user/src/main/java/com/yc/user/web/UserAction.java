package com.yc.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserAction {
	
	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("user")
	public String user(HttpServletRequest req) {
		return String.format("server:user ; ip:%s ; port:%s",
				req.getLocalAddr(),
				req.getLocalPort());
	}
	
	/**
	 * 	127.0.0.1:8002 ==> 用户地址
	 * 	浏览器测试地址: http://127.0.0.1:8001/order
	 * 	
	 */
	@GetMapping("order")
	public String order() {
		String url="http://order/order";
		String res = restTemplate.getForObject(url, String.class);
		return res;
	}
	

}
