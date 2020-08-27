package com.yc.order.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAction {
	
	@GetMapping("order")
	public String order(HttpServletRequest req) {
		return String.format("server:order ; ip:%s ; port:%s",
				req.getLocalAddr(),
				req.getLocalPort());
	}

}
