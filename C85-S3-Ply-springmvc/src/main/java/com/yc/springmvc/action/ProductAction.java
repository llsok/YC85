package com.yc.springmvc.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.bean.DmProduct;
import com.yc.damai.dao.DmProductMapper;

@RestController("pAction")
public class ProductAction {

	@Resource
	private DmProductMapper pm;

	/**
	 * Model ==> 数据模型  ==> Map集合可以替代Model
	 * 	返回Model 必须是 页面跳转方式才可以,
	 * 	如果是Ajax 通过参数注入的 Map 或 Model ,里面会默认设置一个视图名
	 * 		导致错误, ajax 方式不能设置视图名
	 * @return
	 */
	@GetMapping(path="product.do",params="op=query")
	public Map<String, Object> query(DmProduct dp) {
		 dp.setIsHot(1);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("list", pm.selectByObj(dp));
		return m;
	}
}
