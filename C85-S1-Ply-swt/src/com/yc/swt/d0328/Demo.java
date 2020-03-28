package com.yc.swt.d0328;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 *	java图形开发技术:  
 *		swing 官方提供的        基于java虚拟机     跨平台性
 *		SWT eclipse 提供的图形开发包	基于操作系统   性能高
 * 
 *  Shell 窗体   ===>  Display对象负责调用操作系统的图形接口
 *  
 * 	 常用控件:
 * 	Label: 	文本标签
 * 	Text:	文本输入框
 * 	Button: 按钮, 有多重种形态, 在构建( new )时传入不同的类型参数, 
 * 			就会构建出不同的按钮( 多选框 , 单选框, 按钮...)
 * 
 * 	创建文本标签
 * 	第一个参数:  表示控件所在容器控件
 * 	第二个参数:  整数, 表示该控件展示的样式, NONE表示默认样式
 * 	Label label = new Label(shell, SWT.NONE);
 * 
 * 	创建文本输入框
 * 	textName = new Text(shell, SWT.BORDER | SWT.CENTER);
 * 
 * 	容器控件: 内部放置其他的控件的控件,  Composite, Shell
 * 
 * 	布局管理器: XxxxLayout
 * 	1. Fill   填充布局
 * 	2. Stack  卡片布局
 * 	3. Row    行布局
 * 	4. Form	    表单布局  磁性布局
 * 	5. Grid	    网格布局
 * 	6. Border 边界布局:  Swing
 * 
 * 	事件 : Event
 * 	addXxxxListener 添加事件监听器:  键盘事件,   鼠标点击 ==> 匿名内部类
 * 
 * 	高级SWT控件
 * 		下拉框
 * 		列表框
 * 		菜单
 * 		标签控件
 * 		表格控件 ==>   MIS 系统
 * 
 */
public class Demo {

}
