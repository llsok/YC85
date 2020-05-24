package com.yc.web.d0523;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/0523/home.s")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("-----------"+session.getId());
		// 获取属性值
		String user = (String) session.getAttribute("loginedUser");
		/*if(user==null) {
			response.getWriter().append("please login!");
		} else {*/
			response.getWriter().append("loginedUser : " + user);
		//}
	}

}
