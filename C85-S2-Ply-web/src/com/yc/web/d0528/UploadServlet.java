package com.yc.web.d0528;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * maxFileSize 最大文件大小 字节单位
 * maxRequestSize 上传文件总大小的限制
 * fileSizeThreshold 临时保存文件的大小设置
 * location 临时保存的文件目录
 * 表单提交必须使用 的属性 method="post"	enctype="multipart/form-data"
 */
@MultipartConfig()
@WebServlet("/upload.s")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getParts();  // 获取所有上传的文件(多文件上传)
		
		Part part = request.getPart("file");
		part.getName();// 文件上传字段名  file
		String filename = part.getSubmittedFileName();// 获取上传的文件名
		part.getSize();// 文件大小
		part.write("d:/"+filename);
		response.getWriter().append("文件上传成功!");
		
		// 文件必须放在工程的里面
		
		// 返回该文件 web 路径
		
		
		
	}

}
