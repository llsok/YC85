package com.yc.favorite.bean;

public class Tag implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private String tname;
	private Integer tcount;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getTcount() {
		return tcount;
	}
	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}
	@Override
	public String toString() {
		return "Tag [tid=" + tid + ", tname=" + tname + ", tcount=" + tcount + "]";
	}
}
