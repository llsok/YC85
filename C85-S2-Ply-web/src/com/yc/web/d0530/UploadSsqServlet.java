package com.yc.web.d0530;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/0530/uploadSsq.do")
public class UploadSsqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("file");
		String webpath = "/0530";
		String diskpath = request.getServletContext().getRealPath(webpath);
		System.out.println(diskpath);
		diskpath = diskpath + "/" + part.getSubmittedFileName();
		part.write(diskpath);
		// 保存数据库
		new SsqDao().insert(diskpath);
		response.getWriter().append("双色球文件上传成功!");
	}

}
