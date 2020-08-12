package com.yc.spring.aop;

public class StaticProxy {
	
	public static void main(String[] args) {
		Subject ps = new ProxySubject();
		ps.say();
	}

}

// 抽象主题
interface Subject{
	void say();
}

// 真实主题 : 被告
class RealSubject implements Subject {
	public void say() {
		System.out.println("真的不是我干的!");
	}
}

// 代理主题: 律师
class ProxySubject implements Subject {
	// 被代理对象 : 被告
	RealSubject rs = new RealSubject();
	public void say() {
		System.out.println("我的当事人有不在在场的证据!");
		rs.say();
		System.out.println("我的当事人有不在在场的证据!");
	}
}











