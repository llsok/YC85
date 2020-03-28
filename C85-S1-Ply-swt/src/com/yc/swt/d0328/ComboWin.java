package com.yc.swt.d0328;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ComboWin {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ComboWin window = new ComboWin();
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
		shell.setText("SWT Application");

		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(10, 52, 88, 25);

		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(129, 52, 88, 25);

		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(252, 52, 88, 25);

		// 添加省下拉列表选项
		combo.setItems(Address.provinces);

		// 添加选择事件的监听器
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 返回触发事件的控件
				// e.getSource();
				// 获取选中的选项的索引
				int index = combo.getSelectionIndex();
				String[] ctiys = Address.citys[index];
				combo_1.setItems(ctiys);
			}
		});

		// 添加选择市时, 联动刷新 区下拉列表 的选项
		combo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * {湖南, 湖北}
				 * {{衡阳,长沙}, {武汉,宜昌}}
				 * {{{雁峰区,蒸湘区},...}  ....  }
				 */
				int pIndex = combo.getSelectionIndex();
				int cIndex = combo_1.getSelectionIndex();
				String[] countys = Address.countys[pIndex][cIndex];
				combo_2.setItems(countys);
			}
		});

	}
}
