package com.yc.web.d0607;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GetCategoryChildrenServlet.do")
public class GetCategoryChildrenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryDao cdao = new CategoryDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("id");
		if (pid == null) {
			pid = "0";
		}
		
		// 将实体类集合转换为 easyui 的树节点集合
		List<TbCategory> list = cdao.queryByParentId(pid);
		List<EUINode> elist = new ArrayList<>();
		for (TbCategory tc : list) {
			EUINode en = new EUINode("" + tc.getId(), tc.getZh());
			// 设置是否有子节点
			if(tc.getLevel() < 3) {
				en.setState("closed");
			} else {
				en.setState("open");
			}
			elist.add(en);
		}
		
		response.getWriter().print(new Gson().toJson(elist));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
