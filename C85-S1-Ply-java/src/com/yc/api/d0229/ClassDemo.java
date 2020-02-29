package com.yc.api.d0229;

/**
 *	Class 类的类
 */
public class ClassDemo {
	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException,
			NoSuchFieldException, InstantiationException, 
			IllegalAccessException {
		/**
		 * 	获取类对象的方法
		 * 		1, 使用 class 关键字
		 * 		2,Class.forName("类完全限定名") 静态方法
		 * 			类完全限定名 = 包名 + 类名
		 * 		3,使用 getClass 对象成员方法
		 */
		System.out.println(A.class);
		try {
			System.out.println(Class.forName("com.yc.api.d0229.ClassDemo$A"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 引用转型
		Object o = new A();
		System.out.println(o.getClass());
		
		Class cls = o.getClass();
		
		/**
		 * 类的构成元素:  方法, 属性, 构造方法, 块,  内部类
		 * 	类对象可以动态的获取这些元素对象
		 * 
		 * Unhandled exception type NoSuchMethodException
		 */
		System.out.println(cls.getMethod("hashCode"));  // 获取方法对象
		// 异常如果不try catch 那么就继续扔出去
		
		System.out.println(cls.getField("name"));  // 获取属性对象
		
		A aa = (A) cls.newInstance();	// 创建对象   ===> new A();
		
		System.out.println(aa);
		
		System.out.println(o); // 
		
		o.toString();
		
	}
	
	// 内部类 完全限定名 : com.yc.api.d0229.ClassDemo$A
	static class A{
		public String name;
	}

}

