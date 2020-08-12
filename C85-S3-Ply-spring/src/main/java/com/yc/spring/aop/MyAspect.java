package com.yc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	// aspectj 的切点表达式
	// execution 定义要拦截方法签名的描述
	// execution( public void 包名.类名.方法名(参数))
	@Pointcut(("execution( * com.yc.spring.dao.*Dao.select*(..))"))
	public void aspect1() {
		/*切点方法*/ }

	@Before("aspect1()")
	// JoinPoint 连接点对象 ==> 方法 ==> 反射对象Method
	// 接口注入 JoinPoint 对象
	public void before(JoinPoint jp) {
		jp.getArgs(); // 方法参数
		jp.getSignature(); // 方法签名吗
		System.out.println("========== 前置增强 ===========");
	}

	@After("aspect1()")
	public void after(JoinPoint jp) {
		System.out.println("========== 后置增强 ===========");
	}

	/**
	 * returning = "ret" 表示业务方法产生返回值 要注入到的方法参数的名称
	 * @param jp
	 * @param ret
	 */
	@AfterReturning(value = "aspect1()", returning = "ret")
	public void afterReturning(JoinPoint jp, Object ret) {
		System.out.println("========== 返回增强 ===== " + ret + " ======");
	}

	/**
	 * throwing="e" 表示业务方法产生异常 要注入到的方法参数的名称
	 * @param jp
	 * @param e
	 */
	@AfterThrowing(value = "aspect1()", throwing="e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		System.out.println("========== 异常增强 ======== " + e.getMessage() +" ===");
	}

	/**
	 * 环绕增强, 业务方法需要我们自己来执行
	 */
	@Around("execution( * com.yc.spring.dao.Oracle*.select*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		Object ret = null;
		try {
			// 调用业务对象的方法
			long begin = System.currentTimeMillis();
			ret = pjp.proceed();
			long end = System.currentTimeMillis();
			System.out.println("一共消耗了" + ((end - begin) / 1000) + "秒");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	// 如果不拦截 hello 那么hello对象就是 new Hello() 出来的
	@After("execution(*  com.yc.spring.Hello.*(..))")
	public void afterForHello(JoinPoint jp) {
		System.out.println("========== Hello 后置增强 ===========");
	}

}
