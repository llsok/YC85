package com.yc.web.d0607;

import java.util.ArrayList;
import java.util.List;

public class EUINode {

	private String id;
	private String text;
	private String iconCls;
	private boolean checked;
	private String state;
	private Object attributes;
	private List<EUINode> children = new ArrayList<>();
	
	public EUINode(String text) {
		this(text,text);
	}
	
	public EUINode(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public List<EUINode> getChildren() {
		return children;
	}

	public void setChildren(List<EUINode> children) {
		this.children = children;
	}

	public void addChild(EUINode node) {
		this.children.add(node);
	}

}
