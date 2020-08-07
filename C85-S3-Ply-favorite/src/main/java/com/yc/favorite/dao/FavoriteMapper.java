package com.yc.favorite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import com.yc.favorite.bean.Favorite;

public interface FavoriteMapper {

	@Insert("insert into favorite values(null"
			+ ",#{flabel},#{furl},#{fdesc},#{ftags})")
	@Options(useGeneratedKeys = true
			, keyColumn = "fid", keyProperty = "fid")
	int insert(Favorite f);
	
	/**
	 * tid == null  查未分类
	 * tid == 0		查全部
	 * tid >  0		查指定分类
	 * @param tid
	 * @return
	 */
	List<Favorite> selectByTid(@Param("tid")Integer tid);

}
