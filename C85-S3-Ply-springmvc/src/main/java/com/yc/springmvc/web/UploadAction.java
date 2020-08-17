package com.yc.springmvc.web;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadAction {

	@PostMapping(path="upload",produces="text/html;charset=utf-8")
	public String upload(@RequestParam("file") MultipartFile file) 
			throws IllegalStateException, IOException {
		String diskpath = "F:/Tomcat/webapps/photo/images/fulls/";
		String filename = file.getOriginalFilename(); // 文件名
		file.transferTo(new File(diskpath + filename));
		// 请问: 假设我上传文件名是 a.jpg
		// 那么, 对应web路径是多少呢?
		System.out.println("success: " + "photo/" + filename);
		return "success: " + "photo/" + filename;
	}

}
