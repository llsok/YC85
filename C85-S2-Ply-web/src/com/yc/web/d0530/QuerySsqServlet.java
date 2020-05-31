package com.yc.web.d0530;

import java.io.IOException;
import java.util.HashMap;
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
	
	// dao对象 可以共用
    private SsqDao ssqDao = new SsqDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取分页参数  第几页
		String page = request.getParameter("page");
		int iPage = 1;
		if(page!=null && page.trim().isEmpty() == false) {
			iPage = Integer.valueOf(page);
		}
		
		List<Map<String,Object>> list = ssqDao.queryPage(iPage,5);
		
		int pages = ssqDao.countPages(5);
		
		// 使用 ? 对象保存  list 和 pages  =>  Map
		Map<String,Object> data = new HashMap<String,Object>();
		
		data.put("list", list);
		data.put("pages", pages);
		
		// Gson google 开发的 JSON 工具, 可以将对象转成 json 字符串 或者方向操作
		Gson gson = new Gson();
		
		System.out.println(data);
		
		String json = gson.toJson(data);
		
		System.out.println(json);
		
		response.getWriter().append(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
