package com.yc.C85S3PlySpringBoot.biz;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MyWebSocket {
	// Hashtable 用来存放每个客户端对应的 id : Session 对象。
	private static Hashtable<String, Session> webSocketMap = new Hashtable<>();

	// 连接建立成功调用的方法
	@OnOpen
	public void onOpen(@PathParam("id") String id, Session session) {
		// HashMap(线程不安全) Hashtable(线程安全) 区别
		System.out.println(id + " 已经连接成功!");
		webSocketMap.put(id, session);
	}

	// 连接关闭调用的方法
	@OnClose
	public void onClose(Session session) {
		// 移除 webSocketMap 中的会话
	}

	// 收到客户端消息后调用的方法
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		// String msg = "a:你好";
		String[] ss = message.split(":");
		String id = ss[0];
		Session targetSession = webSocketMap.get(id);
		if (targetSession != null) {
			targetSession.getBasicRemote().sendText(message);
		} else {
			System.out.println(id + "不在线!");
		}
	}

	// 没2分钟执行一次
	@Scheduled(cron = "0 */2 * * * ?")
	public void luckYou() throws IOException {
		for (Session session : webSocketMap.values()) {
			session.getBasicRemote().sendText("祝你好运!");
		}
	}

}
