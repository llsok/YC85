package com.yc.swt.scott;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class EmpEditDialog extends Dialog {

	// 结果对象
	protected Object result;
	
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EmpEditDialog(Shell parent, int style) {
		super(parent, style);
		setText("员工编辑");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(),
				SWT.DIALOG_TRIM | 
				// 模态化
				SWT.PRIMARY_MODAL);
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(179, 92, 80, 27);
		button.setText("保存");

	}
}
