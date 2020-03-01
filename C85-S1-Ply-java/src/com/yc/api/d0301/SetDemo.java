package com.yc.api.d0301;

import java.util.*;

/**
 * Set集合
 */
public class SetDemo {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("武松");
		set.add("武松");
		set.add("武松");
		set.add("李逵");
		set.add("宋江");
		set.add("林冲");
		for(String person : set) {
			System.out.print(person + "; ");
		}
		
		System.out.println();
		/**
		 * HashSet 是无序的,  LinkedHashSet 是有序
		 */
		set = new LinkedHashSet<>();
		set.add("武松");
		set.add("武松");
		set.add("武松");
		set.add("李逵");
		set.add("宋江");
		set.add("林冲");
		
		for(String person : set) {
			System.out.print(person + "; ");
		}
	}

}
