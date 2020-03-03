package com.yc.api.d0301;

import java.util.*;
import java.util.Map.Entry;

import com.yc.api.d0229.NameHelper;

/**
作业：
	1, 随机生成1000个数字(0~100)， 存入ArrayList集合中， 统计出现次数最多的数字
	
	2, 随机生成1000个姓名， 存入TreeSet集合中， 统计出现次数最多的姓氏
		注意: 
			1, 该例要用到随机取名的类, 请童邪们先完成随机取名的作业
			2, 从第二个案例开始, 程序流程与第一个基本一致, 只有几个细节不一样, 大部分代码可以复用, 不需要重写
			
	3, 随机生成1000个日期(1900~现在)， 存入LinkedList集合中， 统计出现次数最多的年份

提示：使用   Map 集合进行统计
	被统计的值作为键，数量作为值。循环集合中的每个值，添加到 Map 集合中，第二次遍历到的值，
	取出 Map 中数量并且+1，再存回 Map 中，完成统计。

扩展作业:
	1,任意给出一遍文章, 请统计出现最多的字
		例如这段文字: 在java的面向对象的特性里，父类的引用可以指向子类的实例对象。但是，如果一个引用b（b本身指向了一个对象）想赋值给引用a，b不是a的类型且不是a的子类类型，那么就需要强制转换，并有失败的可能性，这个时候就需要instanceof关键字来判断。instanceof关键字的用途就是，判断引用b指向的对象，是不是a类型的或a的子类类型。 
		
	2, 参考身份证编码规则, 随机生成 1000 个身份证号码, 统计出几月份出生的人数最多

 */
public class Exercise {

	private Random random = new Random();

	public static void main(String[] args) {
		Exercise exer = new Exercise();
		exer.countNumber();
		exer.countName();
		exer.countDate();
	}

	/**
	 * 	随机生成1000个数字(0~100)， 存入ArrayList集合中， 统计出现次数最多的数字
	 */
	public void countNumber() {
		List<Integer> list = new ArrayList<>();
		// 随机生成1000个数字(0~100)， 存入ArrayList集合中
		for (int i = 0; i < 1000; i++) {
			list.add(random.nextInt(101));
		}
		// 定义存放统计结果的 Map
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer number : list) {
			// 根据当前数值, 从 Map 集合中获取统计数, 也就是该数字的计数器变量
			Integer count = map.get(number);
			if (count == null) {
				// count 为空, 说明是第一次取到的数字, 直接给 count 赋值为 1
				count = 1;
			} else {
				// 否则 计数器变量 + 1
				count++;
			}
			// 关键一步: 把计数器变量放回 Map 中
			map.put(number, count);
		}
		// 定义出现最多的数字和计数器
		int countNumber = 0;
		int maxCount = 0;
		// 遍历 map 集合, 统计结果
		for (Entry<Integer, Integer> en : map.entrySet()) {
			int number = en.getKey();
			int count = en.getValue();
			if (count > maxCount) {
				maxCount = count;
				countNumber = number;
			}
		}
		// 输出结果
		System.out.println("\r\n================一道华丽的分割线=================");
		System.out.println("共随机生成 " + list.size() + " 个数字");
		System.out.printf("出现次数最多的是: %s, 共出现了 %s 次\n", countNumber, maxCount);
	}

	/**
	 *	随机生成1000个姓名， 存入TreeSet集合中， 统计出现次数最多的姓氏
	 *	注意: 
	 *		1, 该例要用到随机取名的类, 请童邪们先完成随机取名的作业
	 *		2, 第二个例子的程序流程与前一个基本一致, 只有几个细节不一样, 大部分代码可以复用, 不需要重写
	 */
	public void countName() {
		Set<String> set = new TreeSet<>();
		// 随机生成1000个姓名， 存入TreeSet集合中
		while (set.size() < 1000) {
			set.add(NameHelper.createName());
		}
		Map<Character, Integer> map = new HashMap<>();
		for (String name : set) {
			// 获取名字中的姓氏, 暂不考虑复姓的情况, 例如:欧阳, 司马 ....
			char xing = name.charAt(0);
			// 根据当前姓氏字符, 从 Map 集合中获取统计数, 也就是该姓氏的计数器变量
			Integer count = map.get(xing);
			if (count == null) {
				// count 为空, 说明是第一次取到的姓氏, 直接给 count 赋值为 1
				count = 1;
			} else {
				// 否则 计数器变量 + 1
				count++;
			}
			// 关键一步: 把计数器变量放回 Map 中
			map.put(xing, count);
		}
		// 定义出现最多的姓氏和计数器
		char countName = Character.MIN_VALUE;
		int maxCount = 0;
		// 遍历 map 集合, 统计结果
		for (Entry<Character, Integer> en : map.entrySet()) {
			char name = en.getKey();
			int count = en.getValue();
			if (count > maxCount) {
				maxCount = count;
				countName = name;
			}
		}
		// 输出结果
		System.out.println("\r\n================一道华丽的分割线=================");
		System.out.println("共随机生成 " + set.size() + " 个姓名");
		System.out.println("所有生成的姓名, 注意: 用的是 TreeSet 集合, 输出的结果是排序过的:\r\n" + set);
		System.out.printf("出现次数最多的是: %s, 共出现了 %s 次\n", countName, maxCount);
	}
	
	/**
	 * 	随机生成1000个日期(1900~现在)， 存入LinkedList集合中， 统计出现次数最多的年份
	 */
	public void countDate() {
		List<Date> list = new LinkedList<>();
		// 随机生成1000个姓名， 存入TreeSet集合中
		while (list.size() < 1000) {
			// 生成随机浮点数, 注意: 该随机值是 0~1 之间的小数
			double d = random.nextDouble();
			// 创建当前时间对象
			Date date = new Date();
			// 获取日期的时间戳
			long time = date.getTime();
			// 时间戳 * 随机值 = 1970 ~ 现在  的一个随机时间
			time = (long) (time * d);
			// 重新设置时间戳
			date.setTime(time);
			// 添加时间对象
			list.add(date);
		}
		
		// 注意: 要统计的是年份, 所以 Map 中的键应该保存年份的数值, 而不是整个 Date 对象
		Map<Integer, Integer> map = new HashMap<>();
		
		// 定义日历对象, 用于获取时间 date 对象中的年份
		Calendar cal = Calendar.getInstance();
		
		for (Date date : list) {
			// 给日历对象 cal 重新设置日期值
			cal.setTime(date);
			// 获取日期中的年份
			int year = cal.get(Calendar.YEAR);
			// 根据当前日期的年份, 从 Map 集合中获取统计数, 也就是该年份的计数器变量
			Integer count = map.get(year);
			if (count == null) {
				// count 为空, 说明是第一次取到的年份, 直接给 count 赋值为 1
				count = 1;
			} else {
				// 否则 计数器变量 + 1
				count++;
			}
			// 关键一步: 把计数器变量放回 Map 中
			map.put(year, count);
		}
		// 定义出现最多的姓氏和计数器
		int countYear = Character.MIN_VALUE;
		int maxCount = 0;
		// 遍历 map 集合, 统计结果
		for (Entry<Integer, Integer> en : map.entrySet()) {
			Integer year = en.getKey();
			int count = en.getValue();
			if (count > maxCount) {
				maxCount = count;
				countYear = year;
			}
		}
		// 输出结果
		System.out.println("\r\n================一道华丽的分割线=================");
		System.out.println("共随机生成 " + list.size() + " 个日期");
		System.out.printf("出现次数最多的是: %s 年, 共出现了 %s 次\n", countYear, maxCount);
	}
}
