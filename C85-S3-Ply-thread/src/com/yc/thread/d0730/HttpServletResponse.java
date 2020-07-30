package com.yc.thread.d0730;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HttpServletResponse {

	// 通过 Socket 获取的输出流
	private OutputStream out;
	private int status;
	private String msg;
	// 存放头域键值对的map集合
	private Map<String, String> headerMap = new HashMap<>();

	public HttpServletResponse(OutputStream out) {
		this.out = out;
	}

	// 资源流 字符串输出流, 将输出内容保存到一个字符串中
	private CharArrayWriter caw = new CharArrayWriter();
	// 处理流
	private PrintWriter pw = new PrintWriter(caw);

	/**
	 * 获取响应输出流(打印流) 临时保存 servlet 输出的内容
	 * @return
	 */
	public PrintWriter getWriter() {
		return pw;
	}

	/**
	 * 设置结果码和结果码消息
	 * @param statuc
	 * @param msg
	 */
	public void setStatus(int status, String msg) {
		// 如果已经设置了结果码, 那么就不再设置
		if(this.status==0) {
			this.status = status;
			this.msg = msg;
		}
	}

	/**
	 * 将响应报文推送给浏览器
	 * @throws IOException 
	 */
	public void flushBuffer() throws IOException {
		// 响应头行
		out.write(("HTTP/1.1 " + status + " " + msg + "\n").getBytes());
		// 响应头域
		out.write(("Content-Type: text/html; charset=utf-8\n").getBytes());
		// 将头域集合中的值写入响应报文
		for (Entry<String, String> entry : headerMap.entrySet()) {
			out.write((entry.getKey() + ": " + entry.getValue() + "\n").getBytes());
		}
		// 空行 CRLF
		out.write("\n".getBytes());
		// 实体
		out.write(caw.toString().getBytes());
	}

	/**
	 * 	响应重定向方法
	 * @param uri 要跳转的页面
	 */
	public void sendRedirect(String uri) {
		// 写结果码 301 or 302
		setStatus(301, "Redirect");
		// 在头域中写入 Location: 要转的页面
		headerMap.put("Location", uri);
	}

}
