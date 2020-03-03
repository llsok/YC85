package com.yc.api.d0303;

import java.io.*;

/**
 * 	流的分类
 * 	方向: 
 * 	输入:   InputStream ( 字节输入流  ),        Reader( 字符输入流  )
 * 	输出:   OutputStream ( 字节输出流  ),     Writer( 字符输出流  )
 * 
 */
public class StreamDemo {

	public static void main(String[] args) {
		// 定义 文件输入字符流
		FileReader fr = null;
		try {
			fr = new FileReader("d:/a.txt");
			char[] buffer = new char[1024];// 定义读入的缓存区变量
			int count;
			do {
				count = fr.read(buffer); // count是每次读入字符数
				if(count != -1) {
					String txt = new String( buffer, 0, count );
					System.out.println(txt);
				}
			} while( count != -1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void write() {
		// 在 d:/a.txt 写入文字信息
		// 定义 文件输出字符流
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:/a.txt");
			fw.write("定义 文件输出字符流");

		} catch (IOException e) {
			// 打印异常, 压制异常
			e.printStackTrace();
		} finally {
			// fw cannot be resolved fw未定义
			if (fw != null) {
				try {
					/**
					 * 	流在操作完成之后必须要关闭( 无论流操作是否失败,都必须关闭 )
					 * 	原因:
					 * 		1. 确保数据写到文件中
					 * 		2.不关闭流, 会导致文件一直被程序打开,导致程序无法访问该文件
					 */
					fw.close(); // 关闭流
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
