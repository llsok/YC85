package com.yc.web.d0607;

import java.util.List;

import com.yc.web.util.DBHelper;

public class CategoryDao {
	
	public List<TbCategory> queryByParentId(String pid){
		return new DBHelper().query(
				"select * from tb_category where parent_id=?",
				TbCategory.class, 
				pid);
	}

}
