package com.yc.thread.d0726;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络基本概念: IP 端口
 * 协议: ISO 7层结构 ==> TCP/IP ==> socket
 * 
 * URL: 用户访问远程服务资源 ==> 服务器资源访问 ==> Tomcat 服务器
 * Socket: 计算机相互通讯 ==> QQ
 * 
 * 多线程 + URL ==> 多线程下载(迅雷下载)
 * 
 * 实现过程
 * 1. 单线程下载
 * 2. 单线程分块下载
 * 	  1. 获取文件总大小 (从conn获取)
 * 	  2. 每块的大小 (自定义)
 * 	  3. 字节流的 skip() 跳过N个字节
 * 3. 多线程分块下载
 * 	  1. 进度统计(顺便被打乱)
 *    2. 合并的时机, 要等到所有的块下载完成才能合并
 *    3. 时间的统计
 *    
 *    隐患: 对块数的限制 12M / 2M = 6
 *    	1024M / 2M = 512 个子线程
 *    	千万别下大文件
 *    	必须要进行块数的限制     downNums 不能超过 10
 *    
 */
public class Demo {

	/**当前正在下载块*/
	private int downNums = 0;

	public static void main(String[] args) throws IOException, InterruptedException {
		new Demo().download();
	}

	// 定义下载方法
	public void download() throws IOException, InterruptedException {
		/**
		 * 忽略 SSL 验证  (高航提供)
		 */
		// SslUtils.ignoreSsl();

		URL url = new URL(
				"https://mirror.bit.edu.cn/apache/tomcat/tomcat-10/v10.0.0-M7/bin/apache-tomcat-10.0.0-M7-windows-x64.zip");

		String filename = "d:/apache-tomcat-10.0.0-M7-windows-x64.zip";
		long time = System.currentTimeMillis();

		URLConnection conn = url.openConnection();
		// 获取文件总大小
		int filesize = conn.getContentLength();
		// 每块的大小 (自定义 2M)
		int blocksize = 1 * 1024 * 1024;
		// 计算块数
		int blocknums = filesize / blocksize;
		if (filesize % blocksize != 0) {
			blocknums++;
		}
		System.out.println("开始下载");

		// 分块下载
		for (int i = 0; i < blocknums; i++) {
			/**  开启线程下载     */
			downNums++;
			
			/** 在此等待  限制下载的线程数量 */
			synchronized (this) {
				// 如果当前下载的块数 大于 0 则继续等待
				while (downNums > 10) {
					System.out.println("当前下载的块数达到10!");
					wait();
				}
			}
			
			int index = i; // jdk 会自动对其 加 final
			new Thread() {
				public void run() {
					try {
						// 匿名类中访问的外部变量必须是 final 修饰的变量
						System.out.println("第" + (index + 1) + "块开始下载");
						/**在每次循环中 获取 一个连接对象*/
						URLConnection conn = url.openConnection();
						InputStream in = conn.getInputStream();
						FileOutputStream out = new FileOutputStream(filename + index);
						// 开始的字节数
						int beginBytes = index * blocksize;
						// 结束的字节数
						int endBytes = beginBytes + blocksize;
						// 结束的字节数不能超过文件的大小
						if (endBytes > filesize) {
							endBytes = filesize;
						}
						// 跳过开始的字节数
						in.skip(beginBytes);
						/**
						 * 	请下载当前块内的字节数
						 * 	1. 计数
						 * 	2. 判断
						 */
						// 当前下载到的位置
						int position = beginBytes;
						byte[] buffer = new byte[1024];
						int count;
						while ((count = in.read(buffer)) > 0) {
							if (position + count > endBytes) {
								// 计算超出部分
								int a = position + count - endBytes;
								// 减去超出的部分
								count = count - a;
							}
							out.write(buffer, 0, count);
							// 更新下载位置( 向前推进 )
							position += count;
							// 如果下载位置已经到达该块结束位置
							if (position >= endBytes) {
								break;
							}
						}
						in.close();
						out.close();
						System.out.println("第" + (index + 1) + "块结束下载");
						// 匿名类中访问外部类对象的方式是  Demo.this
						synchronized (Demo.this) {
							Demo.this.downNums --;
							// 通知等待中主线程, 尝试完成合并
							Demo.this.notify();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}.start();

		}

		/** 在此等待   */
		synchronized (this) {
			// 如果当前下载的块数 大于 0 则继续等待
			while (downNums > 0) {
				wait();
			}
		}

		// 合并文件
		marge(filename, blocknums);
		/**
		 * 请清空临时保存的小文件
		 */
		System.out.println("共花了" + (System.currentTimeMillis() - time) / 1000 + "秒");
		System.out.println("下载完成");
	}

	// 合并文件
	public static void marge(String path, int filenums) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		for (int i = 0; i < filenums; i++) {
			FileInputStream fis = new FileInputStream(path + i);
			byte[] buffer = new byte[1024];
			int count;
			while ((count = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
			fis.close();
		}
		fos.close();
	}

}
