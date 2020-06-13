package com.yc.web.d0613;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/0610/推箱子/SaveServlet.do")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PushBoxDao pbd = new PushBoxDao();
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String game = request.getParameter("game");
		String level = request.getParameter("level");
		String data = request.getParameter("data");
		try {
			pbd.save(name, game, level, data);
			response.getWriter().print("游戏保存成功!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			response.getWriter().print("游戏保存失败!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
