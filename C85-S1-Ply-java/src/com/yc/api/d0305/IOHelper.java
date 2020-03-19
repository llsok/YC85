package com.yc.api.d0305;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO工具类
 */
public class IOHelper {

	/**
	 * 	关闭流的工具方法,  所有的流都实现了 Closeable 方法, 所以都有close 方法, 也就是说:
	 * 	Closeable 是所有流的父类,  这里使用的就是OOP多态性
	 * @param c
	 */
	public static void close(AutoCloseable c) {
		if (c != null) {
			/**
			 * 	关于如何打开错误解决窗口 
			 * 	1, 鼠标停在 报错 点上, eclipse 会给出解决方案, 其中就包括 try
			 * 	2, 光标停在 报错 点上  ctrl + 1
			 */
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
