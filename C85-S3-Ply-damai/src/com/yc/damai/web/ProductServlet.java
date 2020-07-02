package com.yc.damai.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.ProductDao;
import com.yc.damai.util.DBHelper;

@WebServlet("/product.do")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDao pdao = new ProductDao();
    
	protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from dm_product where is_hot=1 limit 0,10";
		List<?> list = new DBHelper().query(sql);
		HashMap<String,Object> page = new HashMap<>();
		page.put("list", list);
		print( response, page);
	}
	
	protected void query1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows"); 
		
		List<?> list = pdao.query1(page, rows);
		int total = pdao.count1();
		
		HashMap<String,Object> data = new HashMap<>();
		data.put("rows", list);
		data.put("total", total);
		print( response, data);
	}
	
	// 查询某件商品
	protected void queryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String sql = "select * from dm_product where id = ?";
		List<?> list = new DBHelper().query(sql, id);
		print( response, list.get(0));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
