package com.yc.thread.d0730;

public class ToIndexServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 	实现响应重定向 
		 */
		response.sendRedirect("/photo/index.html");
	}
	
}
