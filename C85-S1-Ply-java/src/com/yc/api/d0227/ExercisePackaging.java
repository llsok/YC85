package com.yc.api.d0227;

/**
 * 常用 Integer 方法汇总练习
 * 请根据每行注释的描述，执行指定的方法，并输出结果
 * 
 * 请参考API: http://www.matools.com/api/java8
 */
public class ExercisePackaging {
	
	public static void main(String[] args) {
		ExercisePackaging e = new ExercisePackaging();
		
		e.testInteger();
		e.testCharacter();
	}
	
	/**
	 * Integer 类练习
	 * 注意：
	 * 		其他数值类型的包装类（Long、Double...）也具有相同或类似方法，
	 * 		请童鞋们自行验证。
	 */
	public void testInteger() {
		
		/**
		 * 构造方法
		 */
		// 请使用 int值 99 作为参数，创建一个 Integer 变量 number1 
		Integer number1 = new Integer(99);
		System.out.println(number1);
		// 请使用 字符串 "88" 作为参数，创建一个 Integer 变量 number2
		Integer number2 = new Integer("88");
		System.out.println(number2);
		
		Integer a = 1;  // 自动装箱  基本数据类型 => 包装类对象
		int b = a;		// 自动拆箱  包装类对象 => 基本数据类型
		
		/**
		 * 实例方法（对象方法）
		 */
		Integer var = 100;
		System.out.println("测试对象 var = " + var);
		// 执行 ???Value() 方法将 i 转换成 byte 类型
		byte v1 = var.byteValue();
		// 执行 ???Value() 方法将 i 转换成 short 类型
		short v2 = var.shortValue();
		// 执行 ???Value() 方法将 i 转换成 int 类型
		
		// 执行 ???Value() 方法将 i 转换成 long 类型
		
		// 执行 ???Value() 方法将 i 转换成 float 类型
		
		// 执行 ???Value() 方法将 i 转换成 double 类型
		
		// 执行 ???To(Integer anotherInteger) 数字比较两个 Integer对象

		/**
		 * 静态属性和方法
		 */
		// 请输出 Integer 类型的最大值
		System.out.println(Integer.MAX_VALUE);
		// 请输出 Integer 类型的最小值
		System.out.println(Integer.MIN_VALUE);
		// 执行 ???Int(String s)，将字符串参数解析为带符号的十进制整数
		System.out.println(Integer.parseInt("999"));
		// 执行 ???(int x, int y)，数字比较两个 Integer对象
		
		// 执行 ???(int a, int b)，返回两个 int的较大值
		
		// 执行 ???(int a, int b)，返回两个 int的较小值
		
		// 执行 ???(int a, int b)，根据+运算符将两个整数相加
		
		// 执行 to???String(int i)，在基数2中返回整数参数的字符串表示形式为无符号整数（转成2进制）
		
		// 执行 to???String(int i)，返回整数参数的字符串表示形式，作为16位中的无符号整数（转成16进制）
		
		// 执行 to???String(int i)，在基数8中返回整数参数的字符串表示形式为无符号整数（转成8进制）
		
		// 执行 ???Of(int i)，返回一个 Integer指定的 int值的 Integer实例（int 转 Integer）
		
		// 执行 ???Of(String s)，返回一个 Integer对象，保存指定的值为 String（String 转 Integer）
		
	}
	
	/**
	 * Character 练习
	 */
	public void testCharacter() {
		/**
		 * 构造方法
		 */
		// 请用构造方法创建一个 Character 对象
		
		/**
		 * 静态属性
		 */
		 // 请输出 char 的最大值
		
		 // 请输出 char 的最小值
		
		/**
		 * 实例方法
		 */
		// 执行 ???Value() 返回此 Character对象的值
		
		// 执行 ???To(Character anotherCharacter) 数字比较两个 Character对象。
		Character c = 'd';
		System.out.println(c.compareTo('c'));
		
		/**
		 * 静态方法
		 */
		// 执行 is???(char ch) 确定指定的字符是否是数字
		System.out.println(Character.isDigit('a'));
		System.out.println(Character.isDigit('6'));
		
		// 执行 is???(char ch) 确定指定的字符是否是一个字母。
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetter('6'));
		
		// 执行 is???(char ch) 确定指定的字符是否是小写字符。
		
		// 执行 is???(char ch) 确定指定的字符是否为大写字符。
		
		// 执行 is???(char ch) 确定指定的字符是否是Unicode空格字符。
		
		// 执行 to???(char ch) 使用UnicodeData文件中的案例映射信息将字符参数转换为大写。
		
		// 执行 to???(char ch) 使用UnicodeData文件中的大小写映射信息将字符参数转换为小写。
		
		// 执行 ???Of(char c)  返回一个 表示指定的 char值的 Character实例。
	}
	
	/**
	 * Boolean 练习
	 */
	public void testBoolean() {
		/**
		 * 构造方法
		 */
		// 使用 boolean值 创建 Boolean对象
		
		// 使用 String值 创建 Boolean对象
		
		/**
		 * 静态属性
		 */
		// 请在控制台输出 Boolean对象对应于原始值 false 。
		
		// 请在控制台输出 Boolean对象对应于原始值 true 。
		
		/**
		 * 实例方法
		 */
		// 执行 ???Value() 将此 Boolean对象的值作为布尔基元返回。
		
		// 执行 ???To(Boolean b) 将此 Boolean实例与另一个实例进行比较。
		
		/**
		 * 静态方法
		 */
		// 执行 ???(boolean x, boolean y) 比较两个 boolean值。
		
		// 执行 get???(String name) 返回 true当且仅当由参数命名的系统属性存在且等于字符串 "true" 。
		
		// 执行 logical???(boolean a, boolean b) 返回将逻辑AND运算符应用于指定的 boolean操作数的结果。
		
		// 执行 logical???(boolean a, boolean b) 返回将逻辑OR运算符应用于指定的 boolean操作数的结果。
		
		// 执行 ???Boolean(String s) 将字符串参数解析为布尔值。
		
		// 执行 ???Of(boolean b) 返回一个 Boolean指定的 boolean值的 Boolean实例。
		
		// 执行 ???Of(String s) 返回一个 Boolean ，其值由指定的字符串表示。
		
	}
	
}
