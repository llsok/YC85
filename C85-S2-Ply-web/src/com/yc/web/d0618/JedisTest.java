package com.yc.web.d0618;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	public static void main(String[] args) {
		// 创建 jedis 对象, 约定: 默认连接 本机 6379 端口
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		// 切换数据库
		jedis.select(0);
		
		Set<String> set = jedis.zrange("shuihu", -3, -1);
		
		// 获取 set 的类型
		System.out.println(set.getClass());
		
		for(String name : set) {
			System.out.println(name);
		}
		
		// 获取 hash 集合  ( map )
		Map<String,String> map = jedis.hgetAll("book1");
		System.out.println(map);
		
		jedis.close();
	}

}
