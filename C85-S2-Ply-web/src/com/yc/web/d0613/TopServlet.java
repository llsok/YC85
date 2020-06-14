package com.yc.web.d0613;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/0610/推箱子/TopServlet.do")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PushBoxDao pbd = new PushBoxDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String top = request.getParameter("top");
		if (top == null) {
			top = "5";
		}
		response.getWriter().append(new Gson().toJson(pbd.top(top)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
