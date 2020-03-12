package com.yc.api.d0312;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yc.api.d0305.IOHelper;

/**
 * 	1, 案例练习: 模拟 cmd 程序
 *	2,API + Util 30 个题, 讲题
 */
public class Cmd {

	/**
	 * dir 查询文件
	 * cd  切换目录
	 * copy复制文件
	 * type查看文件内容
	 * 
	 * 	作业: 请实现
	 * 		rename 重命名
	 * 		del	      删除
	 * 		d:		切换盘符
	 */
	
	private String prompt = "C:\\Users\\Administrator"; // 当前的路径
	private Scanner scanner = new Scanner(System.in);
	
	public void start() {
		System.out.println("Microsoft Windows [版本 10.0.14393]");
		System.out.println("(c) 2016 Microsoft Corporation。保留所有权利。");
		System.out.println();
		while(true) {
			System.out.print(prompt + ">");
			String cmdline = scanner.nextLine();// 读取一行文字
			/*String cmd;
			// 找空格
			int index = cmdline.indexOf(" ");
			
			if(index == -1) {
				cmd = cmdline;
			} else {
				cmd = cmdline.substring(0, index);
			}*/
			
			String[] cmds = cmdline.split(" ");  // 正则表达式  \s 表示空格

			// cmd == null  这里就会报出空指针异常, 使用常量 equals 变量
			if( "dir".equals(cmds[0]) ) {
				dir();
			} else if( "cd".equals(cmds[0]) ) {
				String argrument = cmds.length == 1 ? null : cmds[1];
				cd(argrument);
			} else if( "copy".equals(cmds[0]) ) {
				copy(cmds[1], cmds[2]);
			} else if( "type".equals(cmds[0]) ) {
				type(cmds[1]);
			}
		}
	}
	
	/**
	 * type 用于查看文件内容
	 * 	扩展练习: 判断文件是否存在
	 * @param filename
	 */
	private void type(String filename) {
		File file = new File(prompt, filename);
		FileReader fr = null;
		BufferedReader br = null;	// 缓冲字符流, 可以按行读取
		try {
			fr = new FileReader(file);	  // fr 是资源流
			br = new BufferedReader(fr);  // br 是处理流
			String line = null;
			while(  (  line = br.readLine()  ) != null  ) {
				System.out.println(line);
			}
		} catch(IOException e) {
			System.out.println("文件显示错误!");
		} finally {
			IOHelper.close(fr);
		}
	}

	/**
	 * 	文件复制
	 * 	练习题: 请实现覆盖文件提示信息
	 * @param srcFile	源文件
	 * @param destFile	目标文件
	 */
	private void copy(String srcFilename, String destFilename) {
		File srcFile = new File(prompt, srcFilename);
		File destFile = new File(prompt, destFilename);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			// 标准流的操作
			byte[] buffer = new byte[1024]; //  读取数据的缓存变量, 勺子
			int count;						//  每次读入的字节数
			while(  (  count = fis.read(buffer) )  !=  -1   ) {
				fos.write(buffer, 0, count);
			}
			System.out.printf("已复制%15s个文件\n", 1);
		} catch (IOException e) {
			System.out.println("文件赋值失败!");
		} finally {
			IOHelper.close(fis);
			IOHelper.close(fos);
		}
		
	}



	/**
	 * 	练习题: 请实现 cd 命令不带任何参数的输出效果
	 * @param path
	 */
	public void cd(String path) {
		// null 表示无参数, .. 表示 父目录 , path 表示当前目录的子目录
		if(path == null) {
			System.out.println(prompt);
			System.out.println();
		}else if("..".equals(path)) {
			File f = new File(prompt);	// 创建当前的文件夹对象
			prompt = f.getParent();		// 重新赋值父目录的路径
		} else {
			File f = new File(prompt, path);	// 创建子目录文件对象
			if(f.exists()) {
				prompt = f.getAbsolutePath();	// 将子目录的绝对路径赋值给当前目录 prompt
			} else {
				System.out.println("系统找不到指定的路径。");
			}
		}
	}
	
	/**
	 * dir 默认情况下只查非隐藏文件
	 */
	public void dir() {
		File f = new File(prompt);	// 当前目录
		File[] files = f.listFiles();
		int fileNumber = 0;
		int dirNumber = 0;
		long fileSize = 0;
		for(File file : files) {
			// 判断文件是否是隐藏文件
			if(file.isHidden()) {
				continue;
			}
			
			long time = file.lastModified();// 获取修改日期的时间戳
			Date date = new Date(time);		// 创建指定文件的日期对象
			String mask = "yyyy/MM/dd/E HH:mm";// 掩码
			SimpleDateFormat sdf = new SimpleDateFormat(mask);// ctrl + 1 会打开报错修复方案窗口
			String datestr = sdf.format(date);

			String type = file.isDirectory() ? "<DIR>" : ""; // 判断目录
			
			String size = file.isFile() ? "" + file.length() : "";	// 文件大小, 目录应该不输出大小
			
			String filename = file.getName();
			
			System.out.printf("%s\t%s\t%s\t%s\t\n",datestr,type,size,filename);
			
			fileNumber += file.isFile() ? 1 : 0;			// 记录文件数
			dirNumber += file.isDirectory() ? 1 : 0;		// 记录目录数
			fileSize += file.isFile() ? file.length() : 0;	// 统计文件大小
		}
		// %数字s 定宽输出
		System.out.printf("%15s 个文件%15s 字节\n", fileNumber, fileSize);
		System.out.printf("%15s 个目录%15s 可用字节\n", dirNumber, f.getFreeSpace());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Cmd cmd = new Cmd();
		cmd.start();
	}
	
}
