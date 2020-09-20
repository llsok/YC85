package com.yc.crbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.crbook.bean.CrCart;
import com.yc.crbook.bean.CrCartExample;
import com.yc.crbook.dao.CrCartMapper;

@RestController
@RequestMapping("cart")
public class CartAction {

	@Autowired
	private CrCartMapper cMapper;

	@GetMapping("findByUid")
	List<CrCart> findByUid(@RequestParam int uid) {
		CrCartExample exa = new CrCartExample();
		exa.createCriteria().andUidEqualTo(uid);
		return cMapper.selectByExample(exa);
	}

}
