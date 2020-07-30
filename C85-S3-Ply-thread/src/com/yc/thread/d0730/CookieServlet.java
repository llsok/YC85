package com.yc.thread.d0730;

public class CookieServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 	向浏览器发送Cookie 值 name=wusong
		 */
		Cookie cookie = new Cookie("name","wusong");
		cookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(cookie);
		
		response.getWriter().append("cookie");
		
		/**
		 * 	请为 Cookie 对象设置过期时间 maxAge
		 */
		
	}
	
}
