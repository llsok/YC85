package com.yc.java.d1208;

import java.util.Scanner;

/**
 * 五子棋
 * @author Administrator
 *
 */
public class Wuzi {

	// 定义常量
	public static final char BLACK = '@';	// 黑子
	public static final char WHITE = 'O';	// 白子
	public static final int SIZE = 15;		// 棋盘大小

	public static void main(String[] args) {

		// 定义棋盘
		char[][] qipan = new char[SIZE][SIZE];
		// 初始化棋盘，空格处显示 + 号
		for (int i = 0; i < qipan.length; i++) {
			for (int j = 0; j < qipan[i].length; j++) {
				qipan[i][j] = '+';
			}
		}

		Scanner s = new Scanner(System.in);
		// 黑先下子
		char color = BLACK;
		// 开始游戏
		while (true) {
			// 打印棋盘
			printQipan(qipan);

			// 用户输入棋子坐标
			int i = 0;
			while (i < 1 || i > 15) {
				System.out.print("请输入棋子的横坐标：");
				i = s.nextInt();
			}
			int j = 0;
			while (j < 1 || j > 15) {
				System.out.print("请输入棋子的纵坐标：");
				j = s.nextInt();
			}

			System.out.println();

			// 左边减一，用户输入的是 1~15， 数组下标是 0~14
			j--;
			i--;
			if (qipan[j][i] != '+') {
				System.out.println("您不能在这里下子！");
			} else {
				// 下子
				qipan[j][i] = color;

				// 横向判断 -
				if (checkHeng(qipan, color, i, j)
						// 纵向判断 |
						|| checkZong(qipan, color, i, j)
						// 斜向判断 \
						|| checkXie1(qipan, color, i, j)
						// 斜向判断 /
						|| checkXie2(qipan, color, i, j)) {
					break;
				}

				// 交换棋子颜色
				color = color == BLACK ? WHITE : BLACK;
			}
		}

		// 终局前最后再打印一次棋盘
		printQipan(qipan);

		/**
		 * 作业：
		 * 	1、判断用户的输入（1~15），如果用户输入不正确，则提示用户再次输入   ***
		 * 	2、落子无悔，下过棋的位置不能再次下子，必须提示用户			  ***
		 * 	3、胜负判断  *****
		 * 		1、先判断横向的五子是否成立
		 * 		2、再判断纵向的五子是否成立
		 * 		3、最后考虑如何判断斜向的五子
		 *  
		 */
	}

	/**
	 * 打印棋盘
	 * @param qipan
	 */
	public static void printQipan(char[][] qipan) {
		printXPos();
		for (int i = 0; i < qipan.length; i++) {
			printYPos(i + 1);
			for (int j = 0; j < qipan[i].length; j++) {
				System.out.print(qipan[i][j] + " ");
			}
			printYPos(i + 1);
			System.out.println();
		}
		printXPos();
	}

	/**
	 * 打印横坐标
	 */
	public static void printXPos() {
		System.out.print("  ");
		for (int i = 0; i < SIZE; i++) {
			int num = i + 1;
			System.out.print(num < 10 ? num + " " : num);
		}
		System.out.println();
	}

	/**
	 * 打印纵坐标
	 */
	public static void printYPos(int y) {
		System.out.print(y < 10 ? y + " " : y);
	}

	/**
	 * 判断横向五子是否成立
	 * @param qipan  棋盘
	 * @param color	 棋子颜色
	 * @param i		横坐标
	 * @param j		纵坐标
	 */
	public static boolean checkHeng(char[][] qipan, char color, int i, int j) {

		// 定义进行运算 x y
		int x = i, y = j;
		// 判断横向（左）
		int num = 1;
		while (x > 0 && qipan[y][--x] == color) {
			num++;
		}
		// 恢复 x y 的值
		x = i;
		y = j;
		// 判断横向（右）
		while (x < 14 && qipan[y][++x] == color) {
			num++;
		}

		if (num >= 5) {
			System.out.println(color + "赢了！");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断纵向五子是否成立
	 * @param qipan
	 * @param color
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean checkZong(char[][] qipan, char color, int i, int j) {
		/**
		 * 判断纵向
		 */
		int x = i;
		int y = j;
		// 判断纵向（上）
		int num = 1;
		while (y > 0 && qipan[--y][x] == color) {
			num++;
		}
		// 恢复 x y 的值
		x = i;
		y = j;
		// 判断纵向（下）
		while (y < 14 && qipan[++y][x] == color) {
			num++;
		}

		if (num >= 5) {
			System.out.println(color + "赢了！");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断斜向（ \ ）五子是否成立
	 * @param qipan
	 * @param color
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean checkXie1(char[][] qipan, char color, int i, int j) {
		/**
		 * 判断斜向
		 */
		int x = i;
		int y = j;
		// 判断斜向（左上）
		int num = 1;
		while (y > 0 && x > 0 && qipan[--y][--x] == color) {
			num++;
		}
		// 恢复 x y 的值
		x = i;
		y = j;
		// 判断斜向（右下）
		while (y < 14 && x < 14 && qipan[++y][++x] == color) {
			num++;
		}

		if (num >= 5) {
			System.out.println(color + "赢了！");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断斜向（ / ）五子是否成立
	 * @param qipan
	 * @param color
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean checkXie2(char[][] qipan, char color, int i, int j) {
		/**
		 * 判断斜向
		 */
		int x = i;
		int y = j;
		// 判断斜向（右上）
		int num = 1;
		while (y > 0 && x < 14 && qipan[--y][++x] == color) {
			num++;
		}
		// 恢复 x y 的值
		x = i;
		y = j;
		// 判断斜向（左下）
		while (y < 14 && x > 0 && qipan[++y][--x] == color) {
			num++;
		}

		if (num >= 5) {
			System.out.println(color + "赢了！");
			return true;
		} else {
			return false;
		}
	}

}
