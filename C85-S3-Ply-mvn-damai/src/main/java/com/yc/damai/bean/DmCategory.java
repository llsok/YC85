package com.yc.damai.bean;

import java.util.List;

public class DmCategory {
    private Integer id;

    private String cname;

    private Integer pid;
    
    // 当前分类的子类集合
    private List<DmCategory> children;

    public List<DmCategory> getChildren() {
		return children;
	}

	public void setChildren(List<DmCategory> children) {
		this.children = children;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}