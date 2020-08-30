package com.yc.crbook.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAction {

	@GetMapping("book")
	public String test() {
		return "book";
	}
}
