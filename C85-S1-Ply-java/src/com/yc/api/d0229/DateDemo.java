package com.yc.api.d0229;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateDemo {

	public static void main(String[] args) {
		
		Date now = new Date();
		System.out.println(now);
		long time = now.getTime(); // 获取 1970.1.1 到现在的毫秒值: 时间戳
		time -= 60 * 1000;  // 获取 1分钟前的 时间戳
		Date d1 = new Date( time );
		System.out.println(d1);
		d1.setTime(time - 60 * 60 * 1000);
		System.out.println(d1);
		
		// 日期类型有很多方法已经被废弃
		d1.getHours();
		
		// 如果要获取时间的值, 必须使用 Calender 类 ( 日历 )
		/**
		 * 	日历类支持:
		 * 1,  日期字段的获取(  年月日)
		 * 2,  日期的运算
		 * 
		 *    日历对象的创建, 使用一个工厂方法 ( 静态方法 ) 获取对象, 工厂方法是一种设计模式
		 */
		Calendar cal = Calendar.getInstance();  // 获取当前时间的日历对象
		
		System.out.println(cal.get(Calendar.DATE)); // 该月的日期
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));	// 本月的日期
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));  // 年度的日数
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));  //周中的日期
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));  //当天的小时数。
		
		// 日历转日期 Date  ==> getTime
		
		System.out.println(cal.getTime());  // 打印当前时间
		
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println(cal.getTime());  // 打印加了一天后的时间
		
		/**
		 * 	请 计算 上月今日是星期几 ?
		 */
		// 将日历的时间设置为当前时间
		cal.setTime(  new Date() );
		cal.add(Calendar.MONTH, -1);  // set 设置一个时间 
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		/**
		 * 时间格式化
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String datestr = sdf.format(cal.getTime());
		System.out.println(datestr);
		
		
	}
	
}
