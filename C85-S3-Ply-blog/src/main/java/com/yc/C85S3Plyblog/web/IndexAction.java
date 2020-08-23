package com.yc.C85S3Plyblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.C85S3Plyblog.dao.ArticleMapper;

@Controller
public class IndexAction {

	@Resource
	private ArticleMapper amapper;

	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("alist", amapper.selectByNew());
		return "index";
	}

}
