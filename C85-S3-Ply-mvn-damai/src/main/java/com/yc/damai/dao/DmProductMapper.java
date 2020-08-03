package com.yc.damai.dao;

import java.util.List;

import com.yc.damai.bean.DmProduct;

public interface DmProductMapper {

	List<DmProduct> selectAll();
	
	DmProduct selectById(int id);
}
