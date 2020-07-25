package com.yc.thread.d0725;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {

	public static void main(String[] args) {

		ProducerConsumer pc = new ProducerConsumer();

		new Thread() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

	}

}

// 最简单的生产者消费者模式
class ProducerConsumer {

	private List<Integer> list = new ArrayList<>();

	/**
	 * 	生产方法
	 * @throws InterruptedException 
	 */
	public synchronized void produce() throws InterruptedException {
		while (true) {
			if (list.isEmpty()) {
				for (int i = 0; i < 10; i++) {
					list.add(i);
					System.out.println("-----生成了一个产品" + i);
					Thread.sleep(200);
				}
			} else {
				/**
				 * 如果list 不为空则
				 */
				// 通知等待线程( 消费线程 )
				notifyAll();
				// 当前线程( 生产线程 )等待
				// 一旦进入等待状态, 那么将会释放锁对象
				wait();
			}
		}
	}

	/**
	 * 	消费方法
	 * @throws InterruptedException 
	 */
	public synchronized void consume() throws InterruptedException {
		while (true) {
			if (list.isEmpty() == false) {
				for (int i = 0; i < 10; i++) {
					list.remove(0);
					System.out.println("===消费了一个产品" + i);
					Thread.sleep(100);
				}
			} else {
				/**
				 * 如果list 为空则
				 */
				// 通知等待线程( 生产线程 )
				notifyAll();
				// 当前线程( 消费线程 )等待
				// 一旦进入等待状态, 那么将会释放锁对象
				wait();
			}
		}
	}

}
