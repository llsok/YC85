package com.yc.thread.d0725;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DemoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 只要 new 出 Socket 就会立即和服务器进行连接
		// 默认使用随机端口
		Socket socket = new Socket("127.0.0.1", 8888);

		InetAddress myAddress = socket.getInetAddress();
		SocketAddress otherAddress = socket.getRemoteSocketAddress();
		System.out.println("我的地址:" + myAddress);
		System.out.println("客户端的地址:" + otherAddress);

		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		Scanner sc = new Scanner(System.in);

		new Thread() {
			public void run() {
				byte[] buffer = new byte[1024];
				int count;
				while (true) {
					try {
						// read 在没有收到对方付发回的消息前,会一直阻塞
						count = in.read(buffer);
						System.out.println("他说:" + new String(buffer, 0, count));
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}.start();

		new Thread() {
			public void run() {
				while (true) {
					try {
						// 请回复客户端一个消息!
						System.out.print("我说:");
						out.write(sc.nextLine().getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}.start();
	}

}
