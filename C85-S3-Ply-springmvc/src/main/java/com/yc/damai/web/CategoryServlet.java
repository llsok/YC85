package com.yc.damai.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.CategoryDao;

@WebServlet("/category.do")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryDao cdao = new CategoryDao();

	protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<?> list = cdao.query();
		print(response, list);
	}

}
