package com.yc.swt.d0327;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * SWT 的布局控件, 加在容器控件上面
 * 
 * 1. 绝对布局
 * 2. Fill 填充布局
 * 3. Stack 卡片布局, 每一个控件就是一个卡片, 所有卡片叠在一起, 一次只能看到一个
 * 4. row  行布局
 * 5. form 表单布局
 */

public class LoginWin1 {

	protected Shell shell;
	private Text text;
	private Label label_1;
	private Text text_1;
	private Composite composite;
	private Button button;
	private Button button_1;
	private Label label_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginWin1 window = new LoginWin1();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(434, 226);
		shell.setText("SWT Application");
		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.verticalSpacing = 20;
		gl_shell.horizontalSpacing = 20;
		gl_shell.marginWidth = 30;
		gl_shell.marginHeight = 30;
		shell.setLayout(gl_shell);
		
		Label label = new Label(shell, SWT.NONE);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 64;
		label.setLayoutData(gd_label);
		label.setText("用户名:");
		
		text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		label_1 = new Label(shell, SWT.NONE);
		label_1.setText("密码:");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FormLayout());
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1);
		gd_composite.heightHint = 55;
		composite.setLayoutData(gd_composite);
		
		button = new Button(composite, SWT.NONE);
		FormData fd_button = new FormData();
		fd_button.left = new FormAttachment(100, -76);
		fd_button.top = new FormAttachment(0, 10);
		fd_button.right = new FormAttachment(100, -10);
		button.setLayoutData(fd_button);
		button.setText("放弃");
		
		button_1 = new Button(composite, SWT.NONE);
		FormData fd_button_1 = new FormData();
		fd_button_1.left = new FormAttachment(button, -77, SWT.LEFT);
		fd_button_1.top = new FormAttachment(0, 10);
		fd_button_1.right = new FormAttachment(button, -6);
		button_1.setLayoutData(fd_button_1);
		button_1.setText("登录");
		
		label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage(LoginWin1.class, "/com/yc/swt/d0327/imgs/计算机.png"));
		FormData fd_label_2 = new FormData();
		fd_label_2.top = new FormAttachment(button, 0, SWT.TOP);
		fd_label_2.left = new FormAttachment(0, 10);
		label_2.setLayoutData(fd_label_2);

	}

}
