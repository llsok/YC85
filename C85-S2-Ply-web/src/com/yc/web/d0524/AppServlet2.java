package com.yc.web.d0524;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppServlet2")
public class AppServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 应用上下文对象  ServletContext 全局唯一,  生命周期与服务器一至
		
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext application1 = this.getServletContext();
		ServletContext application2 = request.getServletContext();
		ServletContext application3 = request.getSession().getServletContext();
		
		System.out.println(application1);
		System.out.println(application2);
		System.out.println(application3);
		
		System.out.println("================="+application1.getAttribute("name"));
		
		// 请在此移除  count 属性值
		
	}


}
