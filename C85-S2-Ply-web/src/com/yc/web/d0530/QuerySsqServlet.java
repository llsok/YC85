package com.yc.web.d0530;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/0530/querySsq.do")
public class QuerySsqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Map<String,Object>> list = new SsqDao().queryAll();
		
		// Gson google 开发的 JSON 工具, 可以将对象转成 json 字符串 或者方向操作
		Gson gson = new Gson();
		
		System.out.println(list);
		
		String json = gson.toJson(list);
		
		System.out.println(json);
		
		response.getWriter().append(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
