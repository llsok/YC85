package com.yc.damai.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.yc.damai.po.Result;

/**
 * 	文件上传
 */
@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Part part = request.getPart("file");
		String webpath = "/products/upload";
		String diskpath = request.getServletContext().getRealPath(webpath);
		System.out.println(diskpath);
		diskpath = diskpath + "/" + part.getSubmittedFileName();
		webpath += "/" + part.getSubmittedFileName();
		// 去掉首部的 /
		webpath = webpath.substring(1);
		part.write(diskpath);

		Gson gson = new Gson();
		Result res = new Result( 1, "文件上传成功!", webpath);
		String json = gson.toJson(res);
		response.getWriter().append(json);
	}

}
