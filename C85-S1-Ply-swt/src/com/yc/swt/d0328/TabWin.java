package com.yc.swt.d0328;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TabWin {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TabWin window = new TabWin();
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
		shell.setSize(450, 300);
		shell.setText("文本编辑器");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmNew = new MenuItem(menu, SWT.CASCADE);
		mntmNew.setText("New");

		Menu menu_1 = new Menu(mntmNew);
		mntmNew.setMenu(menu_1);

		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
				tbtmNewItem.setText("New Item");
				Composite composite = new Composite(tabFolder, SWT.NONE);
				tbtmNewItem.setControl(composite);
				composite.setLayout(new FillLayout(SWT.HORIZONTAL));
				Text text = new Text(composite, 
						SWT.BORDER 
						| SWT.WRAP		// 换行 
						| SWT.MULTI 	// 多行
						| SWT.V_SCROLL	// 垂直滚动条
						| SWT.H_SCROLL);// 水平滚动条
				// 将文本读入到 text 中
				readToText(text);
				
				// 重新绘制控件  
				composite.layout();
			}
		});
		mntmOpen.setText("Open");

	}

	// 读取文件到 text 中
	public void readToText(Text text) {
		// 文件选择器 对话框
		FileDialog fd = new FileDialog(shell);
		// 设置文件扩展名
		fd.setFilterExtensions(new String[] { "*.*"});
		fd.setText("请选择文件");
		// open 执行后, 程序便会暂停在这里
		String path = fd.open();
		
		if(path == null) {
			return;
		}
		
		//InputStream is = getClass().getResourceAsStream("版权信息.txt");
		// 读取指定文件
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				text.setText(text.getText() + line + "\r\n");
			}
			fis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 作业: 添加菜单, 实现保存文件
	 */
	
}
