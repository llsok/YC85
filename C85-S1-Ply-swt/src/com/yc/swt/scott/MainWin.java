package com.yc.swt.scott;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWin {

	protected Shell shlScott;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWin window = new MainWin();
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
		shlScott.open();
		shlScott.layout();
		while (!shlScott.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlScott = new Shell();
		shlScott.setSize(580, 430);
		shlScott.setText("Scott管理系统");
		shlScott.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Menu menu = new Menu(shlScott, SWT.BAR);
		shlScott.setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("员工管理");
		
		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);
		
		MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
		menuItem_1.setText("简易版");
		
		TabFolder tabFolder = new TabFolder(shlScott, SWT.NONE);
		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("欢迎页");
		
		Label label = new Label(tabFolder, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(MainWin.class, "/com/yc/swt/scott/imgs/timg.jpg"));
		tabItem.setControl(label);
		

		// 给简易版的菜单添加事件
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
				tabItem.setText("简易版");
				// 选中当前添加的标签页
				tabFolder.setSelection(tabItem);
				
				// 构建标签页的内容
				EmpCmp empCmp = new EmpCmp(tabFolder, SWT.NONE);
				tabItem.setControl(empCmp);
			}
		});
		
	}
	
	/**
	 * 	作业:
	 * 	1. 加入部门, 薪资级别( SALGRADE ) 管理的界面
	 * 		菜单, 标签页, 自定义标签
	 * 	2.组合条件查询
	 * 		使用模糊查询: 姓名 + 职位(JOB)
	 */

}
