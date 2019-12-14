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
		System.out.println("===============初始牌================");
		// 打印52扑克牌
		print(poker);

		System.out.println("===============洗牌================");
		shuffle();
		// 打印52扑克牌
		print(poker);

		System.out.println("===============发牌================");
		licensing();
		
		System.out.println("===============整牌================");
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
		System.out.println("===============作业================");
		/**
		 * 1、假设拿到黑桃3的玩家先出牌，请找出这个玩家
		 */
		// 注意：外循环定义了名称 f1，这就是命名循环
		f1: for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < player[i].length; j++) {
				// 黑桃3 的值是 0
				if (player[i][j] == 0) {
					System.out.println("玩家" + (i + 1) + "手中有黑桃3");
					// 注意： 这里是退出外循环：f1。找到了该玩家，就没必要再循环了！
					break f1;
				}
			}
		}

		/**
		 * 2、假设某玩家出一张牌（例如：黑桃3），请判断下一个玩家要不要的起牌
		 */
		int card = random.nextInt(52); // 随机抽取一张扑克牌
		System.out.print("系统出牌：" + displayCard(card) + "，");
		int iCardColor = card / 13; // 计算该牌的花色
		int iCardNumber = card % 13; // 计算该牌的牌号
		int winCard = -1;
		for (int i = 0; i < player[0].length; i++) { // 判断玩家一要不要的起该牌
			int iColor = player[0][i] / 13; // 计算玩家当前这张牌的花色
			int iNumber = player[0][i] % 13; // 计算玩家当前这张牌的牌号
			/**
			 * 规则：玩家手中必须有相同花色，并且是牌号比该牌要大的牌
			 */
			if (iCardColor == iColor && iCardNumber < iNumber) {
				winCard = player[0][i];
			}
		}
		if (winCard >= 0) {
			System.out.println("玩家一要的起该牌，可以出：" + displayCard(winCard));
		} else {
			System.out.println("玩家一要不起该牌!");
		}

		/**
		 * 3、假设某玩家出对张牌（例如：一对3），请判断下一个玩家要不要的起牌
		 */
		/**
		 * 解法：
		 * 1、假定这对3是：黑桃3 + 梅花3，那么牌值就是： 0，26，对 13 取余后，牌号都是 0；
		 * 2、那么玩家手中必须有一对牌大于3，一对牌的定义是：相同的牌号（对13取余后的值相同）
		 * 3、编写双层循环，外循环从出牌的牌号开始，到12结束（12是最大的牌号），查找大于出的这对牌的牌号
		 * 4、内循环用外循环产生的牌号，对玩家手中的牌进行查找，查找相同牌号的牌，并记录下来
		 */
		int[] cards = { 0, 26 };
		// 计算该对牌的牌号，花色已经没意义了
		int iCardsNumber = cards[0] % 13;
		// 定义记录重复牌的数组
		int[] winCards = new int[4];
		// 定义重复牌的张数
		int count = 0;
		for (int i = iCardsNumber + 1; i < 13; i++) {
			/**
			 * 记录牌的数组，初始值为 -1，不设置-1就是0，0是黑桃3，所以必须改
			 * 一副牌重复牌最多是4张，所以数组元素是4个
			 */
			winCards = new int[] { -1, -1, -1, -1 };
			count = 0;
			// 遍历玩家一手中的牌
			for (int j = 0; j < player[0].length; j++) {
				int iNumber = player[0][j] % 13;
				if (i == iNumber) {
					winCards[count] = player[0][j];
					count++;
				}
			}
			if (count >= cards.length) {
				break;
			}
		}
		if (count >= cards.length) {
			System.out.print("玩家一要的起该牌，可以出：");
			for (int i = 0; i < winCards.length; i++) {
				if (winCards[i] >= 0) {
					System.out.print(displayCard(winCards[i]) + ",");
				}
			}
			System.out.println();
		} else {
			System.out.print("玩家一要不起该牌！");
		}

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
		// 循环牌数组
		for (int i = 0; i < cards.length; i++) {
			// 将牌值转换成 花色 + 牌号
			System.out.print(displayCard(cards[i]) + ",");
		}
		System.out.println();
	}

	/**
	 * 根据牌值转换成对应的花色+牌号字符串，因为该功能有多个地方要使用，所以抽取成一个函数
	 * @param card
	 * @return 返回结果格式：梅花5，黑桃A。。。
	 */
	public static String displayCard(int card) {
		// 花色数组
		String[] colors = { "黑桃", "红桃", "梅花", "方块" };
		// 牌号数组
		String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
		// 花色数值
		int iColor = card / 13;
		// 牌号数值
		int iNumber = card % 13;
		// 字符串连接
		return colors[iColor] + numbers[iNumber];
	}

}
