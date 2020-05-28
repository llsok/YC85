package com.yc.web.d0528;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verify.do")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户输入的验证码
		String vcode = request.getParameter("vcode");
		// 获取会话中的验证码
		String scode = (String) request.getSession().getAttribute("vcode");

		if (vcode != null && vcode.trim().isEmpty() == false) {
			if (vcode.equalsIgnoreCase(scode)) {
				response.getWriter().append("验证码正确!");
			} else {
				response.getWriter().append("验证码错误!");
			}
		} else {
			response.getWriter().append("请输入验证码!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
