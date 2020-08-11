package com.yc.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MySQLUserDao implements UserDao{

	public int selectUserId(String name) {
		System.out.println("mysql user dao");
		int i = 1 / 0;
		return 0;
	}

}
