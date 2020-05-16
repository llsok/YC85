package com.yc.web.d0516;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
1. 继承 ==> HttpServlet
2. 实现(重写) ==> doGet or doPost ....
3. 配置 ==> web.xml  注解方式 @WebServlet
 * @author 廖彦
 * http://127.0.0.1/C85-S2-Ply-web/hello.s 
 */
@WebServlet("/hello.do")
public class HelloServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("==========" + this);
		
		// 获取响应对象的流对象, 用于向浏览器输出内容
		PrintWriter out = resp.getWriter();
		out.println("Hello world");
	}

	@Override
	public void destroy() {
		System.out.println("=======destroy========" + this);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("=======init========" + this);
	}


	
}
