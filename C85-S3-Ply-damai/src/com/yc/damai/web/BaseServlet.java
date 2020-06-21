package com.yc.damai.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 所有的业务servlet的父类,  BaseServlet 不能被直接创建成功对象, 如何从语法上确保
 */
// @WebServlet("/BaseAction")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * ProductServlet 商品操作的servlet, 产品查询\修改\删除...
	 * product.do?op=query   查询
	 * product.do?op=add     新增
	 * product.do?op=del     删除
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取操作字段
		String op = request.getParameter("op");
		// java 的黑科技 ==> 反射技术
		// 通过 op 获取 方法对象
		try {
			Method method = this.getClass().getDeclaredMethod(op, HttpServletRequest.class, HttpServletResponse.class);
			// 设置方法的可以被访问
			method.setAccessible(true);
			// 执行方法
			method.invoke(this, request, response);
		} catch (Exception e) {
			// 捕获异常
			e.printStackTrace();
			response.getWriter().append("系统错误!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// 输出页面内容
	protected void print (HttpServletResponse response, Object obj) throws IOException {
		response.getWriter().print(new Gson().toJson(obj));
	}
	
}
