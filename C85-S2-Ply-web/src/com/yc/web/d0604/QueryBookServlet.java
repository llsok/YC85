package com.yc.web.d0604;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/QueryBookServlet.do")
public class QueryBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookDao bdao = new BookDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String press = request.getParameter("press");
		String date = request.getParameter("date");
		Gson gson = new Gson();
		String json = gson.toJson(bdao.query(name, press, date));
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
