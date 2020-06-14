package com.yc.web.d0613;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
			// cookie 默认不支持非西方文字
			// 使用utf-8编码对字符进行URL编码, 解决编码问题
			name = URLEncoder.encode(name, "UTF-8");
			// 创建cookie对象
			Cookie cookie = new Cookie("pushboxName",name);
			// 原因 maxAge ==> 有效期, 不设置则保存在内存中, 单位 : 秒
			cookie.setMaxAge(60 * 60 * 24 * 7);// 保存一周
			// 将cookie写入响应对象==>发送浏览器==>保存到某个( 内存, 硬盘)
			response.addCookie(cookie);
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
