package ycjdbc0323;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Demo2 {
	static Random random = new Random();

	static Calendar cal = Calendar.getInstance();
	static String s1;
	//static java.util.Date s2;
	 //java.sql.Timestamp 
		public static Timestamp createDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			int month =random.nextInt(9);
			int day=random.nextInt(23);
			int year = random.nextInt(9);
			cal.setTime(new java.util.Date() );//设置当前时间
			cal.add(Calendar.YEAR, -year);//改变时间
			cal.add(Calendar.MONTH, month);
			cal.add(Calendar.DAY_OF_YEAR, day);
			java.util.Date s2=cal.getTime();//改变后的时间
			long time=s2.getTime();//获取改变时间后的毫秒值
			java.sql.Timestamp d = new java.sql.Timestamp(time);//获取SQL日期
			s1 = sdf.format(s2);
			return  d;

		}

}
