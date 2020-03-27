package com.yc.swt.d0327;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginWin {
	// 窗口对象
	protected Shell shell;
	private Text textName;
	private Label label_1;
	private Text textPwd;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginWin window = new LoginWin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		// display 显示 ==>负责调用操作系统图形接口
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * 	创建窗体的内容
	 */
	protected void createContents() {
		shell = new Shell();
		// 设置大小
		shell.setSize(363, 231);
		// 设置文本
		shell.setText("登录窗口");
		
		Label label = new Label(shell, SWT.NONE);
		// 设置大小
		label.setBounds(36, 47, 61, 17);
		// 设置文本
		label.setText("用户名:");
		
		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(103, 44, 190, 23);
		
		label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(36, 87, 61, 17);
		label_1.setText("密码:");
		
		textPwd = new Text(shell, SWT.BORDER);
		textPwd.setBounds(103, 84, 190, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 创建消息提示框
				MessageBox mb = new MessageBox(shell);
				mb.setText("系统提示");
				// 用户 yc 密码 123
				if("yc".equals(textName.getText()) &&
						"123".equals(textPwd.getText())) {
					// 登录成功
					mb.setMessage("登录成功!");
				} else {
					// 登录失败
					mb.setMessage("登录失败!");
				}
				mb.open();
			}
		});
		button.setBounds(103, 136, 80, 27);
		button.setText("登录");
		
		// 按钮控件
		Button btnNewButton = new Button(shell, SWT.NONE);
		/**
		 * 	 添加一个响应事件的监听器( SelectionAdapter )
		 * 	widgetSelected 是监听器方法, 当鼠标点击时会执行的方法 
		 */
		// 匿名内部类的写法, 接口和抽象类可以在匿名内部类中 直接创建
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 关闭窗口
				shell.dispose();
			}
		});
		btnNewButton.setBounds(189, 136, 80, 27);
		btnNewButton.setText("放弃");

	}
}
