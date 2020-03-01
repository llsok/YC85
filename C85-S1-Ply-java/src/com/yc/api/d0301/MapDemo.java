package com.yc.api.d0301;

import java.util.*;
import java.util.Map.Entry;

/**
 * Map 接口:  
 * 实现类:
 * 	HashMap, LinkedHashMap, TreeMap, Properties
 * 	Hashtable( 类似于 List 接口的实现类  Vector , 线程安全的) 
 *	Properties 用于存储数据到文件中, io
 */
public class MapDemo {

	public static void main(String[] args) {
		
		Person person1 = new Person("宋江",40);
		Person person2 = new Person("卢俊义",43);
		Person person3 = new Person("公孙胜",45);
		Person person4 = new Person("吴用",42);
		
		/**
		 * K key 键
		 * V value 值
		 * 
		 * Map 接口:  
		 * 1, 键不可重复,  value 可以重复
		 * 2, 如果put 了重复的键, 那么将替换之前的值
		 */
		Map<Integer,Person> map = new HashMap<>();
		map.put(1, person1);
		map.put(2, person2);
		map.put(3, person3);
		map.put(4, person4);
		map.put(1, new Person("花荣",20));
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		
		/**
		 * Map 集合的遍历
		 * Entry 是 Map 的静态的内部接口
		 * entry 封装了 一对 键值对
		 */
		Set< Entry<Integer,Person> > entrySet = map.entrySet();
		
		for( Entry<Integer,Person> en : entrySet) {
			System.out.println(en.getKey() + " : " + en.getValue());
		}
		
	}
}
