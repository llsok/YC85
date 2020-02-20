package com.yc.java.d0220;

/**
 * 测量工具接口
 */
public interface IMeasurer {
	
	/**
	 *  用于测量某个对象的属性值，并返回
	 * @param obj
	 * @return
	 * 	思考：如果要测量身高或体重实现类要怎么写
	 */
	double measure(Object obj);
	
}
