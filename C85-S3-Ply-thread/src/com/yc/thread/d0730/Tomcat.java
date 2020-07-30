package com.yc.thread.d0730;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Tomcat {
	// Servlet容器
	private HashMap<String, Servlet> servletMap;

	public void startup() throws IOException {

		// 服务器初始化Servlet容器 ==> Map集合 ==> URL:Servlet对象
		servletMap = new HashMap<>();
		servletMap.put("/photo/hello", new HelloServlet());
		// 让ToIndexServlet称为网站的默认页面
		servletMap.put("/", new ToIndexServlet());
		servletMap.put("/index", new ToIndexServlet());
		servletMap.put("/toindex", new ToIndexServlet());
		// 注册cookie servlet
		servletMap.put("/cookie", new CookieServlet());
		servletMap.put("/login.jsp", new LoginPageServlet());
		servletMap.put("/photo/post.do", new LoginPageServlet());
		
		
		// 启动服务监听8080端口
		// 循环生成 socket 对象
		// 使用线程处理浏览器发送的请求
		ServerSocket tomcat = new ServerSocket(8080);
		System.out.println("tomcat 服务器启动完成, 监听端口:8080");
		boolean running = true;
		while (running) {
			Socket socket = tomcat.accept();

			new Thread() {
				public void run() {
					try {
						System.out.println("接收到请求");
						InputStream in = socket.getInputStream();
						OutputStream out = socket.getOutputStream();
						byte[] buffer = new byte[102400];
						int count;
						count = in.read(buffer);
						if (count > 0) {
							// 打印请求报文
							String requestText = new String(buffer, 0, count);
							System.out.println(requestText);

							// 解析请求报文
							HttpServletRequest request = buildRequest(requestText);
							HttpServletResponse response = new HttpServletResponse(out);
							// 使用资源地址区分动态请求和静态请求
							// 使用资源地址到Servlet容器中获取 Servlet对象
							String uri = request.getRequestURI();
							Servlet servlet = servletMap.get(uri);
							if (servlet != null) {
								// 使用 Servlet 处理动态请求
								servlet.service(request, response);
							} else {
								// 处理静态请求
								processStaticReuqest(request, out);
							}
						}
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}.start();
		}
		// Unreachable code 代码不可达
		tomcat.close();
	}

	public void shutdown() {

	}

	/**
	 * 解析请求对象
	 * @param requestText
	 * @return
	 */
	private HttpServletRequest buildRequest(String requestText) {
		return new HttpServletRequest(requestText);
	}

	public static void main(String[] args) throws IOException {
		new Tomcat().startup();
	}

	/**
	 * 处理静态请求
	 * @param request
	 * @param out
	 * @throws IOException
	 */
	public void processStaticReuqest(HttpServletRequest request, OutputStream out) throws IOException {

		// 如果没有找到对应的Servlet对象, 那么将其视为静态请求
		String webpath = request.getRequestURI();
		String contentType;
		// 结果码
		int statusCode = 200;
		// 定义磁盘文件路径
		String path = "F:/Tomcat/webapps/" + webpath;
		File file = new File(path);
		if (!file.exists()) {
			statusCode = 404;
			path = "F:/Tomcat/webapps/photo/404.html";
		}
		if (webpath.endsWith(".js")) {
			contentType = "application/javascript; charset=utf-8";
		} else if (webpath.endsWith(".css")) {
			contentType = "text/css; charset=utf-8";
		} else {
			// 潜规则: 图片可以返回 html , 浏览器可以自动识别
			contentType = "text/html; charset=utf-8";
		}
		// 响应头行
		out.write(("HTTP/1.1 " + statusCode + " OK\n").getBytes());
		// 响应头域
		out.write(("Content-Type: " + contentType + "\n").getBytes());
		// 空行 CRLF
		out.write("\n".getBytes());
		// 实体
		// out.write("<h1>Hello World</h1>".getBytes());

		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[1024];
		int count;
		while ((count = fis.read(buffer)) > 0) {
			out.write(buffer, 0, count);
		}
		/**
		 * 问题:
		 * 	1.只能回复一次    			OK
		 * 	2.回复的内容永远不变
		 * 		1)解析出请求行中的资源名 /photo/new.html
		 * 		2)读取文件内容输出到实体中
		 */
		fis.close();
		// 处理静态请求
		// 判断资源是否存在, 如果不存在返回404

	}

}
