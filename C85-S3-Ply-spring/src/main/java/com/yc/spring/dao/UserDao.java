package com.yc.spring.dao;

import org.apache.ibatis.annotations.Insert;

import com.yc.spring.bean.Person;

public interface UserDao {

	public int selectUserId(String name);

	@Insert("insert into person values (#{name},#{age})")
	public int insert(Person person);
}
