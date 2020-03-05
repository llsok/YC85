package com.yc.api.d0305;

import java.io.Serializable;

/**
 * 	学生类 (  实体类   )
 * 
 * 	Serializable 序列化接口, 没有定义方法, 它是一个标志接口
 * 	所有实现序列化接口的类, 都要提供一个序列化版本编号的静态变量
 */
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String sn;
	private int chinese;
	private int math;
	private int physics;
	
	/**
	 * 	构造方法创建学生, 自动生成
	 */
	public Student(String name, String sn, int chinese, int math, int physics) {
		super();
		this.name = name;
		this.sn = sn;
		this.chinese = chinese;
		this.math = math;
		this.physics = physics;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", sn=" + sn + ", chinese=" + chinese + ", math=" + math + ", physics="
				+ physics + "]";
	}

}
