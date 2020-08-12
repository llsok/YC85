package com.yc.spring.dao;

import org.springframework.stereotype.Repository;

import com.yc.spring.bean.Person;

@Repository("mdao")
public class MySQLUserDao implements UserDao{

	public int selectUserId(String name) {
		System.out.println("mysql user dao");
		int i = 1 / 0;
		return 85;
	}

	public int insert(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

}
