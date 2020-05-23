package com.yc.web.d0523;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/0523/Servet1")
public class Servet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 当浏览器访问 Sevlet1 时 ,通过 Cookie 向浏览器发送一个 cookie 数据
		// Cookie 只能存少量的数据   一个网站只能存 4K字节,  50个数据项
		// cookie 默认不支持非西方文字  , 要支持必须转码
		Cookie cookie = new Cookie("nm","root"); // 参数1 cookie的名 参数2cookie的值
		//cookie.setPath(...) ; //设置路径
		//cookie.setMaxAge(0); // 设置有效期 单位 秒
		// 将cookie发送给浏览器
		response.addCookie(cookie);
		
		
		cookie = new Cookie("age","18"); // 参数1 cookie的名 参数2cookie的值
		cookie.setPath("/C0-S2-Ply-demo/page1") ;// 设置路径
		//cookie.setMaxAge(0); // 设置有效期 单位 秒
		// 将cookie发送给浏览器
		response.addCookie(cookie);
		
		response.getWriter().append("cookie add success");
		
	}


}
