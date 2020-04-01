package com.yc.swt.scott;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EmpEditDialog extends Dialog {

	// 结果对象
	protected Object result;
	
	protected Shell shell;
	private Text textEmpno;
	private Text textEname;
	private Text textJob;

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
		shell.setLayout(new FormLayout());
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				save();
			}
		});
		FormData fd_button = new FormData();
		fd_button.bottom = new FormAttachment(100, -10);
		fd_button.right = new FormAttachment(100, -115);
		fd_button.left = new FormAttachment(0, 249);
		button.setLayoutData(fd_button);
		button.setText("保存");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("放弃");
		FormData fd_button_1 = new FormData();
		fd_button_1.left = new FormAttachment(button, 19);
		fd_button_1.top = new FormAttachment(button, 0, SWT.TOP);
		fd_button_1.right = new FormAttachment(100, -23);
		button_1.setLayoutData(fd_button_1);
		
		Label label = new Label(shell, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(0, 22);
		fd_label.left = new FormAttachment(0, 51);
		label.setLayoutData(fd_label);
		label.setText("员工编号:");
		
		textEmpno = new Text(shell, SWT.BORDER);
		FormData fd_textEmpno = new FormData();
		fd_textEmpno.right = new FormAttachment(button_1, -21, SWT.RIGHT);
		fd_textEmpno.top = new FormAttachment(0, 19);
		fd_textEmpno.left = new FormAttachment(label, 21);
		textEmpno.setLayoutData(fd_textEmpno);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("员工姓名:");
		FormData fd_label_1 = new FormData();
		fd_label_1.top = new FormAttachment(label, 17);
		fd_label_1.right = new FormAttachment(label, 0, SWT.RIGHT);
		label_1.setLayoutData(fd_label_1);
		
		textEname = new Text(shell, SWT.BORDER);
		FormData fd_textEname = new FormData();
		fd_textEname.right = new FormAttachment(textEmpno, 0, SWT.RIGHT);
		fd_textEname.top = new FormAttachment(textEmpno, 11);
		fd_textEname.left = new FormAttachment(textEmpno, 0, SWT.LEFT);
		textEname.setLayoutData(fd_textEname);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("岗位:");
		FormData fd_label_2 = new FormData();
		fd_label_2.top = new FormAttachment(label_1, 19);
		fd_label_2.left = new FormAttachment(label, 0, SWT.LEFT);
		label_2.setLayoutData(fd_label_2);
		
		textJob = new Text(shell, SWT.BORDER);
		FormData fd_textJob = new FormData();
		fd_textJob.right = new FormAttachment(textEmpno, 0, SWT.RIGHT);
		fd_textJob.top = new FormAttachment(textEname, 13);
		fd_textJob.left = new FormAttachment(label_2, 45);
		textJob.setLayoutData(fd_textJob);

	}
	
	/**
	 * 	保存员工信息
	 */
	private void save() {
		// 封装实体对象 emp
		Emp emp = new Emp();
		emp.setEmpno(Integer.valueOf(textEmpno.getText()));
		emp.setEname(textEname.getText());
		emp.setJob(textJob.getText());
		// 调用 dao 方法
		new EmpDao().insert(emp);
		// 关闭窗口
		shell.close();
		
		// 刷新表格( 父窗口 )
		
	}

}
