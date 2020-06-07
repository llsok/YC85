package com.yc.web.d0607;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.web.d0604.BookDao;

@WebServlet("/GetBookpressItemsServlet.do")
public class GetBookpressItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookDao bdao = new BookDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print(new Gson().toJson(bdao.getBookpressItems()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
