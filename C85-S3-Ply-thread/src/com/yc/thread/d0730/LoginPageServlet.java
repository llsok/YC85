package com.yc.thread.d0730;

public class LoginPageServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		
		//System.out.println(cookies[0]);
		//System.out.println(cookies[1]);
		
		//response.getWriter().append(cookies[0].toString());
		//response.getWriter().append("<br>");
		//response.getWriter().append(cookies[1].toString());
		
		response.getWriter().append("用户名:<input value='"+cookies[0].getValue()+"'><br>");
		response.getWriter().append("密码:<input value=''><br>");
		response.getWriter().append("<input type='button' value='登录'><br>");
		
		
		
		
	}
	
}
