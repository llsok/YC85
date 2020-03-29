package com.yc.swt.scott;

import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class EmpCmp extends Composite {
	private Table table;
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EmpCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new BorderLayout(0, 0));
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(BorderLayout.CENTER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(BorderLayout.NORTH);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(21, 10, 61, 17);
		lblNewLabel.setText("New Label");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(111, 0, 73, 23);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setBounds(318, 0, 80, 27);
		btnNewButton.setText("New Button");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
