package com.yc.damai.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.CartDao;
import com.yc.damai.dao.OrderitemDao;
import com.yc.damai.dao.OrdersDao;

@WebServlet("/orders.do")
public class OrdersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrdersDao odao = new OrdersDao();
	private OrderitemDao oidao = new OrderitemDao();
	private CartDao cdao = new CartDao();

	// 添加订单
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = "2"; // 用户id 从会话中获取 loginedUser.getId(),
		odao.insert(uid);
		oidao.insert(uid);
		cdao.deleteByUid(uid);
		response.getWriter().append("{\"code\":\"1\"}");
	}

	// 查询新增的订单
	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = "2"; // 用户id 从会话中获取 loginedUser.getId(),
		Map<String, Object> ret = new HashMap<>();
		Map<String, Object> orders = odao.queryNewOrders(uid);
		ret.put("orders", orders);
		ret.put("orderitem", oidao.queryByOid("" + orders.get("id")));
		print(response, ret);
	}

}
