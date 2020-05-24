package com.yc.web.d0524;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppServlet1")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 应用上下文对象  ServletContext 全局唯一,  生命周期与服务器一至
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext application1 = this.getServletContext();
		ServletContext application2 = request.getServletContext();
		ServletContext application3 = request.getSession().getServletContext();
		
		System.out.println(application1);
		System.out.println(application2);
		System.out.println(application3);
		
		application1.setAttribute("name", "yc");
		// 统计访问次数  (应用上下文对象)
		Integer count1 = (Integer) application1.getAttribute("count"); // 底层  map => 取不存在的值 返回 null
		// 如果为null 表示第一次获取计数器的值
		count1 = count1 == null ? 1 : (count1+1);
		application1.setAttribute("count", count1);
		
		// 统计访问次数  (会话)
		Integer count2 = (Integer) request.getSession().getAttribute("count");
		count2 = count2 == null ? 1 : (count2+1);
		request.getSession().setAttribute("count", count2);
		
		// 统计访问次数  (请求)
		Integer count3 = (Integer) request.getAttribute("count");
		count3 = count3 == null ? 1 : (count3+1);
		request.setAttribute("count", count3);

		response.getWriter().append(" ServletContext  count = " + count1);
		response.getWriter().append("<br>");
		response.getWriter().append(" session  count = " + count2);
		response.getWriter().append("<br>");
		response.getWriter().append(" request  count = " + count3);
		
	}


}
