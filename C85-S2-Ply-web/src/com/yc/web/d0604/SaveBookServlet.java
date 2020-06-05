package com.yc.web.d0604;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/SaveBookServlet.do")
public class SaveBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bdao = new BookDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("bookname");
		String press = request.getParameter("bookpress");
		String date = request.getParameter("pressdate");
		String author = request.getParameter("bookauthor");
		String count = request.getParameter("bookcount");
		String image = request.getParameter("bookimage");
		try {
			bdao.save(id, name, press, date, author, count, image);
			response.getWriter().print("保存成功");
		} catch (Exception e) {
			response.getWriter().print("保存失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
