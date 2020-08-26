package com.yc.C85S3Plyblog.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.C85S3Plyblog.bean.Category;

public interface CategoryMapper {
	
	@Select("select * from Category where id=#{id}")
	public Category selectById(int id);

}
