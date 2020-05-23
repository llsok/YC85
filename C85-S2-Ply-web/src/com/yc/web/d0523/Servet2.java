package com.yc.web.d0523;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/0523/Servet2")
public class Servet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 从请求获取所有的cookie
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null) {
			response.getWriter().append("no cookie");
		} else {
			for(Cookie c : cookies) {
				// 判断cookie 的 name 值
				if(c.getName().equals("nm")) {
					response.getWriter().append("has nm cookie : " + c.getValue());
				} else {
					response.getWriter().append(c.getName() + " = " + c.getValue());
				}
				
			}
		}
		
	}


}
