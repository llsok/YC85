package com.yc.java.d1208;

import java.util.Scanner;

/**
 * 五子棋
 * @author Administrator
 *
 */
public class Wuzi {

	// 定义常量
	public static final char BLACK = '@';
	public static final char WHITE = 'O';
	public static final int SIZE = 15;

	/**
	 * 黑子 @
	 * 白子 O 
	 * 
	 */
	public static void main(String[] args) {

		// 定义棋盘
		char[][] qipan = new char[SIZE][SIZE];

		for (int i = 0; i < qipan.length; i++) {
			for (int j = 0; j < qipan[i].length; j++) {
				qipan[i][j] = '+';
			}
		}

		Scanner s = new Scanner(System.in);
		char color = BLACK;
		// 开始游戏
		while (true) {
			// 打印棋盘
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
			// 用户输入棋子坐标
			System.out.print("请输入棋子的横坐标：");
			int i = s.nextInt();
			System.out.print("请输入棋子的纵坐标：");
			int j = s.nextInt();

			qipan[j][i] = color;
			// 交换棋子颜色
			color = color == BLACK ? WHITE : BLACK;
		}
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

}
