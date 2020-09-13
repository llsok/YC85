package com.yc.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.crbook.bean.CrBook;
import com.yc.crbook.bean.CrBookExample;
import com.yc.crbook.dao.CrBookMapper;

@RestController
@RequestMapping("book")
public class BookAction {
	
	@Resource
	private CrBookMapper cbm;
	
	@GetMapping("getNewBooks")
	public List<CrBook> getNewBooks(){
		// 构建图书的查询条件以及排序
		CrBookExample cbe = new CrBookExample();
		cbe.setOrderByClause("id desc");
		// 分页查询出前12本书
		PageHelper.startPage(1, 12);
		return cbm.selectByExample(null);
	}

}
