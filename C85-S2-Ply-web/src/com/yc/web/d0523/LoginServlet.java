package com.yc.web.d0523;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/0523/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		if("root".equals(user) && "123".equals(pwd)) {
			// 登录成功之后
			// 获取 会话对象  Session
			HttpSession session = request.getSession();
			System.out.println("======="+session.getId());
			// 向会话对象添加一个属性值
			session.setAttribute("loginedUser", user);
			response.getWriter().append("login success");
		} else {
			response.getWriter().append("login failure");
		}

	}

}
