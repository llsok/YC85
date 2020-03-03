package com.yc.api.d0303;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {

		File dir = new File("E:\\文件柜\\85\\0301");
		//System.out.println(dir.mkdir());  // 创建一个文件夹
		//System.out.println(dir.mkdirs()); // 创建一个多级的文件夹
		
		// 查看文件夹下所有的文件
		String[] filenames = dir.list();	// 返回目录下的文件名数组
		File[] files = dir.listFiles();		// 返回目录下的文件对象数组
		
		System.out.println("==================");
		for (String filename : filenames) {
			System.out.println(filename);
		}
		System.out.println("==================");
		for (File file : files) {
			System.out.println(file);
		}
		
		// 查看文件夹下所有满足某条件的文件
		// 查询 mp4 文件, 用 FilenameFilter 过滤器接口, 来实现过滤查询
		// 使用内部类来实现接口
		System.out.println("=========mp4=========");
		FilenameFilter mp4Filter = new Mp4FilenameFilter();
		String[] mp4Files = dir.list(mp4Filter);
		for (String filename : mp4Files) {
			System.out.println(filename);
		}
		
		// dir.listFiles(FileFilter 文件过滤)  ; // FileFilter 更加强大
		System.out.println("=========小于 1M 的文件=========");
		// 扩展练习: 请过滤查询文件大小小于 1M 的文件
		SizeFileFilter sizeFilter = new SizeFileFilter();
		File[] m1files = dir.listFiles(sizeFilter);
		for (File file : m1files) {
			System.out.println(file);
		}
	}
	
	// 过滤文件大小小于1M的过滤器
	static class SizeFileFilter implements FileFilter{
		@Override
		public boolean accept(File pathname) {
			// 1K = 1024字节 ,  1M = 1024K
			return pathname.length() < 1024 * 1024;
		}
	}
	
	// 过滤MP4的过滤器
	static class Mp4FilenameFilter implements FilenameFilter{
		@Override
		public boolean accept(File dir, String name) {
			boolean ret = name.endsWith("mp4");// 判读文件名是否是 MP4 结尾
			return ret;
		}
	}
	

	public void file() {
		File file = new File("d:/a.txt");
		// Unhandled exception type IOException
		// 未处理的异常 ==> 编译期异常(检查异常)
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 创建一个文件
		System.out.println(file.getName()); // 文件名
		System.out.println(file.getParent()); // 父目录
		System.out.println(file.getPath()); // 文件路径
		System.out.println(file.getAbsolutePath()); // 文件绝对路径
		System.out.println(file.exists()); // 判断文件是否存在
		System.out.println(file.isFile()); // 判断是否为文件
		System.out.println(file.isDirectory()); // 判断是否为目录
		System.out.println(file.length()); // 文件大小
		System.out.println(file.lastModified()); // 最后修改的时间:时间戳

		// 练习, 将该文件的最后修改时间显示在控制台
		Date date = new Date(file.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
	}

}
