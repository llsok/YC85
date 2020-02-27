package com.yc.api.d0227;

/**
 * 字符串练习
 * 请参考API: http://www.matools.com/api/java8
 */
public class ExerciseString1{
	
	public static void main(String[] args) {
		
		//a += "efg";			// a 被重新赋值, 原来的对象值"abc" 成为内存垃圾 
		// String  对象池
		//System.out.println(a);
		
		// 字符串对象池
		
		String a = "a"; 	// a 的值是不可变
		String b = "a";
		System.out.println( a == b);
		String c = new String("a");
		System.out.println( a == c);
		System.out.println( b == c);
		System.out.println(a.equals(c));
		System.out.println(b.equals(c));
		
		// JVM对于字符串有对象池优化技术,使用字面值定义字符串, 可能获取到相同对象( 地址相同 )
		// new String 表示 创建一个新的字符串
		// 字符串的 equals 方法 用于判断 字符串的内容
		System.out.println("=====================");
		ExerciseString1 e = new ExerciseString1();
		e.testString();
		
	}

	public void testString() {
		/**
		 * 构造方法
		 */
		// String(String original) 初始化新创建的String对象，使其表示与参数相同的字符序列; 
		//							换句话说，新创建的字符串是参数字符串的副本。
		String a = new String("abc"); // ==> String a ~= "abc";
		
		// String(char[] value)	分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。
		char[] chars = {'a','b','c'};
		String b = new String(chars);
		System.out.println(b);
		// String(char[] value, int offset, int count) 分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
		
		// String(byte[] bytes) 通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
		byte[] bytes = {100,98,99};
		String c = new String(bytes);
		System.out.println(c);
		
		// String(byte[] bytes, Charset charset) 构造一个新的String由指定用指定的字节的数组解码charset 。
		
		/**
		 * 实例方法
		 */
		// 执行 ???At(int index) 返回 char指定索引处的值。
		String s = "abcde";
		System.out.println(s.charAt(2));
		
		// 执行 ???To(String anotherString) 按字典顺序比较两个字符串。
		
		// 执行 con???(String str) 将指定的字符串连接到该字符串的末尾。
		
		// 执行 con???(CharSequence s) 当且仅当此字符串包含指定的char值序列时才返回true。
		
		// 执行 ???With(String suffix) 测试此字符串是否以指定的后缀结尾。
		System.out.println(s.endsWith("de"));
		System.out.println(s.endsWith("cd"));
		
		// 执行 equals???(String anotherString) 将此 String与其他 String比较，忽略案例注意事项。( 忽略大小写 )
		
		// 执行 get???() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
		
		// 执行 ???Of(char ch) 返回指定字符第一次出现的字符串内的索引。
		System.out.println(s.indexOf('d'));
		
		// 执行 ???Of(char ch, int fromIndex) 返回指定字符第一次出现的字符串内的索引，以指定的索引开始搜索。
		
		// 执行 ???Of(String str) 返回指定子字符串第一次出现的字符串内的索引。
		
		// 执行 ???Of(String str, int fromIndex) 返回指定子串的第一次出现的字符串中的索引，从指定的索引开始。
		
		// 执行 is???() 返回 true如果，且仅当 length()为 0 。
		
		// 执行 ???Of(int ch) 返回指定字符的最后一次出现的字符串中的索引。
		
		// 执行 ???Of(String str) 返回指定子字符串最后一次出现的字符串中的索引。
		
		// 执行 len???() 返回此字符串的长度。
		System.out.println(s.length());
		
		// 执行 replace???(String regex, String replacement) 
		//				用给定的替换替换与给定的 regular expression匹配的此字符串的每个子字符串。
		
		// 执行 replace???(String regex, String replacement)
		//				用给定的替换替换与给定的 regular expression匹配的此字符串的第一个子字符串。
		
		// 执行 sp???(String regex) 将此字符串分割为给定的 regular expression的匹配。
		
		// 执行 ???With(String prefix) 测试此字符串是否以指定的前缀开头。
		
		// 执行 ???string(int beginIndex)(String prefix) 返回一个字符串，该字符串是此字符串的子字符串。
		
		// 执行 ???string(int beginIndex, int endIndex) 返回一个字符串，该字符串是此字符串的子字符串。
		//abcde
		System.out.println(s.substring(1, 4)); // ==> bcd
		
		// 执行 to???() 将此字符串转换为新的字符数组。
		
		// 执行 to???() 将所有在此字符 String使用默认语言环境的规则，以小写。( 转小写 )
		
		// 执行 tr???() 将所有在此字符 String使用默认语言环境的规则大写。( 转大写 )
		
		// 执行 to???() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
		
		/**
		 * 静态方法
		 */
		// 执行 for???(String format, Object... args) 使用指定的格式字符串和参数返回格式化的字符串。
		
	}
}
