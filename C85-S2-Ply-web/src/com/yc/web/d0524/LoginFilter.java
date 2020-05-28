package com.yc.web.d0524;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet 地址配置: 
 * 
 * 1.文件路径匹配:  	/hello.s
 * 2.目录路径匹配:		/page/   匹配  /page/下所有的资源   /page/1  /page/a  /page/adadfa
 * 3.文件后缀名:		*.jsp, *.jpg *.do  *.s
 * 
 * 目录路径匹配 + 文件后缀名  是非法    /page/*.jsp  错
 * 
 */
@WebFilter(urlPatterns= { "*.jsp" , "*.do" , "*.s" })
public class LoginFilter implements Filter {
	
	// 销毁方法
	public void destroy() {
		System.out.println("=========LoginFilter===destroy==================");
	}

	/**
	 * 执行过滤
	 * 
	 * Servlet 
	 * HttpServletRequest req, HttpServletResponse resp
	 * 
	 * ServletRequest request, ServletResponse response
	 * 
	 * FilterChain chain  过滤器链 
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		// 设置请求对象的字符集 ==> post
		request.setCharacterEncoding("UTF-8");
		// 设置响应对象的字符集 
		request.setCharacterEncoding("UTF-8");
		// 设置网页的字符集
		response.setContentType("text/html;charset=utf-8");
		
		/*HttpSession session = ((HttpServletRequest)request).getSession();
		// 获取属性值
		String user = (String) session.getAttribute("loginedUser");
		if(user==null) {
			response.getWriter().append("please login!");
			// 中断执行     不执行 chain.doFilter(request, response);
			return;
		}*/
		// 执行过滤器链中的下一个过滤器的doFilter, 如果已经最后一个过滤器了, 
		// 那么表示允许访问目标资源( jsp,servlet, html, js...)
		chain.doFilter(request, response);
	}

	// 初始化
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("=========LoginFilter===init==================");
	}

}
