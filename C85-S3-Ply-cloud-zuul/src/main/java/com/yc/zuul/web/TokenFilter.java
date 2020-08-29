package com.yc.zuul.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TokenFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 获取当前的请求上下文对象 ==> 对HttpServletRequest的封装
		// Zuul 获取请求对象的方式
		// LocalThread 本地线程变量  扩展学习
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		// 获取传来的参数accessToken
		Object accessToken = request.getParameter("accessToken");
		// 注意: 这里只是示范, 令牌的验证要远比这里复杂
		if (accessToken == null) {
			System.out.println("access token is empty");
			/**
			 * 	过滤该请求，不往下级服务去转发请求，到此结束
			 */
			ctx.setSendZuulResponse(false);
			// 设置响应结果码 401 ==> 浏览器端错误
			ctx.setResponseStatusCode(401);
			// 返回 json 格式报错提示
			ctx.setResponseBody("{\"result\":\"accessToken is empty!\"}");
		}
		// 如果有token，则进行路由转发, 这里return的值没有意义，zuul框架没有使用该返回值
		return null;
	}

	@Override
	public String filterType() {
		/**
		 * pre 前置
		 * rounting 在路由请求时候被调用
		 * post 后置
		 * error 错误
		 */
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
