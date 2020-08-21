package com.yc.C85S3PlySpringBoot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.C85S3PlySpringBoot.dao.ProductMapper;
import com.yc.damai.bean.DmProduct;

@Controller
// 默认情况下, 所有的方法的返回值都被解析成视图
// template 目录下的文件
public class IndexAction {
	
	@Resource
	ProductMapper pm;
	
	@GetMapping("index.do")
	public String index(Model m) {
		
		// 查询热销商品
		List<DmProduct> hlist = pm.selectByHot();
		
		// 推送给页面
		m.addAttribute("hlist", hlist);
		
		return "index";
		// SpringMVC ==> 会将返回视图名 前:template + 视图名 + 后缀 
	}
	
	@GetMapping("detail.do")
	public String detail(Model m, int id) {
		// 查询指定id商品
		DmProduct dp = pm.selectById(id);
		// 推送给页面
		m.addAttribute("dp", dp);
		return "detail";
	}

}
