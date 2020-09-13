package com.yc.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.crbook.bean.CrBook;
import com.yc.crbook.web.remote.IBookAction;

@Controller
public class IndexAction {
	
	@Resource
	private IBookAction baction;

	@GetMapping("/")
	public String index(Model m) {
		
		// 从book 网页获取 最新图书 12本
		// 使用 FeIgn 远程调用 book 的服务
		// 1 定义一个接口,用于访问远程服务
		// 2 调用远程服务
		List<CrBook> newBooks = baction.getNewBooks();
		// 推送给页面
		m.addAttribute("newBooks", newBooks);
		
		return "index";
	}
	
}
