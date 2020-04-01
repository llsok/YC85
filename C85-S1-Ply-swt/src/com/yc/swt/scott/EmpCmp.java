package com.yc.swt.scott;

import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Table;

import java.util.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

public class EmpCmp extends Composite {
	private Table table;
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EmpCmp(Composite parent, int style) {
		super(parent, style);
		// 设置边界布局
		setLayout(new BorderLayout(0, 0));
		
		// 添加表格
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		// 设置表格控件位于 面板的 中间
		table.setLayoutData(BorderLayout.CENTER);
		// 设置表格头可见
		table.setHeaderVisible(true);
		// 设置表格线可见
		table.setLinesVisible(true);
		// 创建表列( 表头 )
		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		// 设置宽度
		tableColumn.setWidth(73);
		tableColumn.setText("员工编号");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("员工姓名");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("职位");
		
		// 自定义容器组件, 用于放置查询条件和按钮
		Composite composite = new Composite(this, SWT.NONE);
		// 设置容器控件位于 面板的 上方( 也就是边界布局的 北部 )
		composite.setLayoutData(BorderLayout.NORTH);
		// 设置网格布局
		GridLayout gl_composite = new GridLayout(6, false);
		gl_composite.marginWidth = 10;
		gl_composite.marginHeight = 10;
		composite.setLayout(gl_composite);
		new Label(composite, SWT.NONE);
		
		Label lblNewLabel = new Label(composite, SWT.RIGHT);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 27;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("姓名:");
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 102;
		text.setLayoutData(gd_text);
		
		Label lblNewLabel_1 = new Label(composite, SWT.RIGHT);
		GridData gd_lblNewLabel_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 41;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setText("岗位:");
		
		text_1 = new Text(composite, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text_1.widthHint = 94;
		text_1.setLayoutData(gd_text_1);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		RowLayout rl_composite_1 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_1.marginHeight = 5;
		composite_1.setLayout(rl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_1.widthHint = 117;
		composite_1.setLayoutData(gd_composite_1);
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				query1();
			}
		});
		btnNewButton.setLayoutData(new RowData(76, SWT.DEFAULT));
		btnNewButton.setText("查询");
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addEmp();
			}
		});
		btnNewButton_1.setLayoutData(new RowData(76, SWT.DEFAULT));
		btnNewButton_1.setText("新增");

		// 执行查询
		query();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	/**
	 * 	查询emp 表, 将结果渲染到表格中
	 */
	public void query() {
		// 添加一行表数据
		EmpDao ed = new EmpDao();
		List<Map<String,Object>> list = ed.selectAll();
		for(Map<String,Object> row : list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] {
					"" + row.get("EMPNO"),
					"" + row.get("ENAME"),
					"" + row.get("JOB")
			});
		}
	}
	
	public void query1() {
		// 封装对象
		Emp emp = new Emp();
		emp.setEname(text.getText());
		emp.setJob(text_1.getText());
		// 调用dao方法
		EmpDao eDao = new EmpDao();
		List<Map<String,Object>> list = eDao.selectByObject(emp);
		// 删除之前的表格数据
		table.removeAll();
		// 刷新表格
		for(Map<String,Object> row : list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] {
					"" + row.get("EMPNO"),
					"" + row.get("ENAME"),
					"" + row.get("JOB")
			});
		}
	}
	
	public void addEmp() {
		// 创建员工信息编辑窗口
		// 模态 ==> 对话框
		EmpEditDialog eed = new EmpEditDialog(getShell(), SWT.NONE);
		eed.open();
	}
	
}
