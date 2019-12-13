package com.yc.java.d1213;

import java.util.Random;

/**
 * 扑克牌
 * 
 * 定义一维数组保存 52 张牌，存放 0~51 的数值
 * 0~12 黑桃   13~25 红桃  26~39 梅花  40~51方块
 * 
 * 功能：
 * 1、洗牌
 * 2、发牌
 * 3、整牌（冒泡排序）
 * 4、显示玩家的牌
 * 5、出牌
 * 
 */
public class Poker {

	static int[] poker = new int[52]; // 扑克
	static int[][] player = new int[4][13]; // 玩家
	static Random random = new Random();

	public static void main(String[] args) {
		// 给每一个牌赋值
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;
		}

		// 打印52扑克牌
		print(poker);

		// 洗牌
		shuffle();

		// 打印52扑克牌
		print(poker);

		// 发牌
		licensing();

		// 整牌（冒泡排序）
		for (int i = 0; i < player.length; i++) {
			// 整理当前玩家的牌
			sort(player[i]);
			System.out.println("玩家" + (i + 1) + "的牌：");
			// 打印当前玩家的牌
			print(player[i]);
		}
		
		/**
		 * 作业：
		 * 	1、假设拿到黑桃3的玩家先出牌，请找出这个玩家
		 * 	2、假设某玩家出一张牌（例如：黑桃3），请判断下一个玩家要不要的起牌
		 * 	3、假设某玩家出对张牌（例如：一对3），请判断下一个玩家要不要的起牌
		 */
	}

	/**
	 * 对数排序（冒泡排序）
	 * @param cards
	 */
	public static void sort(int[] cards) {
		for (int j = 0; j < cards.length - 1; j++) {
			for (int i = 0; i < cards.length - 1 - j; i++) {
				// 如果当前元素 大于 后一个元素，则交换两元素交换位置
				// 改变 > 或 < 会产生 升序 或降序的效果
				if (cards[i] > cards[i + 1]) {
					// 交换元素的位置
					int a = cards[i];
					cards[i] = cards[i + 1];
					cards[i + 1] = a;
				}
			}
		}
	}

	/**
	 * 发牌
	 */
	public static void licensing() {
		for (int i = 0; i < player.length; i++) {
			// 计算发牌的点，在整副扑克牌中的位置
			int index = i * 13; // 0 , 13, 26, 39
			System.arraycopy(poker, index, player[i], 0, player[i].length);
			System.out.println("玩家" + (i + 1) + "的牌：");
			// 打印玩家手中的牌
			print(player[i]);
		}
	}

	/**
	 * 洗牌：遍历每一张牌，将该牌与另外一张随机的牌进行值的交换
	 */
	public static void shuffle() {
		for (int i = 0; i < poker.length; i++) {
			// 生成随机值
			int num = random.nextInt(52);
			// 请交换上面两个数组元素的值
			int c = poker[i];
			poker[i] = poker[num];
			poker[num] = c;
		}
	}

	/**
	 * 打印纸牌
	 * @param cards  整副扑克、玩家手中的牌
	 */
	public static void print(int[] cards) {
		// 花色数组
		String[] colors = { "黑桃", "红桃", "梅花", "方块" };
		// 牌号数组
		String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };

		for (int i = 0; i < cards.length; i++) {
			int iColor = cards[i] / 13; // 花色数值
			int iNumber = cards[i] % 13; // 牌号数值
			String display = colors[iColor] + numbers[iNumber];
			System.out.print(display + ",");
		}
		System.out.println();
	}

}
