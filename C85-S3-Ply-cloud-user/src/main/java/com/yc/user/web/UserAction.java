package com.yc.user.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {
	
	@GetMapping("user")
	public String order() {
		return "user";
	}

}
