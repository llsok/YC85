package com.yc.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.annotations.Insert;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.UserDao;

/**
 *	MyBaits 的会话对象
 * @author 廖彦
 *
 */
public class SqlSession {

	public static void main(String[] args) {

		SqlSession session = new SqlSession();

		UserDao udao = session.getMapper(UserDao.class);

		udao.insert(new Person());

	}

	/**
	 * 泛型方法: 你输入的什么类型, 返回的就是什么类型对象
	 * 根据输入的接口, 返回接口代理对象
	 * MyBaits 动态代理,没有目标兑现   session.getMapper ( UserMapper.class );
	 * @param cls
	 * @return
	 */
	public <M> M getMapper(Class<M> cls) {

		@SuppressWarnings("unchecked")
		M ret = (M) Proxy.newProxyInstance(
				cls.getClassLoader(), 
				new Class[] { cls }, 
				new InvocationHandler() {

			public Object invoke(
					Object proxy, 
					Method method, 
					Object[] args) throws Throwable {

				Insert insert = method.getAnnotation(Insert.class);
				if (insert != null) {
					// 使用 DBHelper 执行 该语句
					System.out.println("执行: " + insert.value()[0]);
					// 根据方法的返回结果, 将dbhelper的执行结果返回
					if(method.getReturnType()!=null) {
						if(method.getReturnType().equals(int.class)) {
							// 如果返回值是 Integer 类型, 这返回 integer 值
							return 0;
						}
					}
				}

				return null;
			}
		});

		return ret;
	}

}
