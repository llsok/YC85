package com.yc.swt.d0327;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class LoginWin {
	// 窗口对象
	protected Shell shell;
	private Text text;
	private Label label_1;
	private Text text_1;

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
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(103, 44, 190, 23);
		
		label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(36, 87, 61, 17);
		label_1.setText("密码:");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(103, 84, 190, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(103, 136, 80, 27);
		button.setText("登录");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(189, 136, 80, 27);
		btnNewButton.setText("放弃");

	}
}
