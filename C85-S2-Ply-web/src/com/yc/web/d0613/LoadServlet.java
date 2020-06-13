package com.yc.web.d0613;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/0610/推箱子/LoadServlet.do")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PushBoxDao pbd = new PushBoxDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String game = request.getParameter("game");
		GameScore gs = pbd.load(name, game);
		if (gs != null) {
			String json = new Gson().toJson(gs);
			response.getWriter().append(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
