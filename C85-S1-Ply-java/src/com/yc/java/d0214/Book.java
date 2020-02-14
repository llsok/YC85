package com.yc.java.d0214;

/**
	构造函数：
	1、系统默认提供无参数的构造函数
	2、如果自定义了构造函数，则系统默认提供的构造函数就失效了
	3、子类的构造方法自动的调用父类的构造方法
	4、子类只能访问父类的非私有（非private）的成员（方法、属性）
	5、继承意义：a）代码复用；b）实现扩展
	
	在Java中，super关键字有两个主要用途；
	第一种用途是：在子类的构造方法中，super关键字可以显式地调用父类的构造方法，用于将参数传递给它；
	其一般语法是： super(实际参数);
	需要注意的是：该语句必须是子类构造方法的第一条语句。
	
	super.方法 或 属性
	super() 调用父类的构造函数
	
	final 关键字表示终结（不变）
	作用：
		1、修饰变量：表示该变量值不可修改
		2、修饰方法：表示该方法不可重写
		3、修饰类：表示该类不可继承
		
	this 指代当前对象
	
	this.属性
	this.方法
	this() ==> 执行当类的其他构造方法  ，也必須在第一行
	this() 和  super() 不能共存
	
 */

public /*final*/ class Book {
	
	public Book() {
		this(10);
		System.out.println("Book 构造方法");
	}
	
	public Book(int a) {
		System.out.println("Book 带参数 a 的构造方法");
	}
	
	protected final int getPrice() {
		
		final int a = 10;
		/**
		 * The final local variable a cannot be assigned. 
		 * It must be blank and not using a compound assignment
		 * final 修饰的变量不可重新复制
		 */
		//a = 12;
		
		
		
		
		return 30;
	}
	
	public static void main(String[] args) {
		//new ComputerBook();
		
		new Book();
		
	}
	
}

/**
 * Implicit super constructor Book() is undefined for default constructor.
 *  Must define an explicit constructor
 *  父类没有缺省的无参数的构造方法
 * @author hy2005zyx
 *
 *The type ComputerBook cannot subclass the final class Book
 * final 类不能不继承
 */
class ComputerBook extends Book {
	
	ComputerBook(){
		// 滴啊用父类的构造方法
		super(10);
		System.out.println("ComputerBook 构造方法");
		/**
		 * Constructor call must be the first statement in a constructor
		 * 该语句必须是子类构造方法的第一条语句。
		 */
		//super(10);
	}
	
	/**
	 * The return type is incompatible with Book.getPrice()
	 * 返回值类型不兼容 父类的 Book.getPrice()
	 */
	//protected float getPrice() { return 0f; }
	
	protected int getPrice(int page){ return  11;}
	
	/**
	 * Duplicate method getPrice() in type ComputerBook
	 * 重复的定义了 getPrice 方法  （重载失败）
	 * /
	//public int getPrice(){return 10;}
	
	/**
	 * Cannot reduce the visibility of the inherited method from Book
	 * 子类重写的方法不能降低父类该方法的可見性（访问作用域）
	 */
	//public   int getPrice( ) {return 0;}
	
	
	/**
	 * Cannot override the final method from Book
	 * final 方法不可重写 （override）
	 */
	/*protected int getPrice() {
		return 10;
	}*/

}