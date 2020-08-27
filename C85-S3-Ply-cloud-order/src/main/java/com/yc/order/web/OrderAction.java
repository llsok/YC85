package com.yc.order.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAction {
	
	@GetMapping("order")
	public String order() {
		return "order";
	}

}
