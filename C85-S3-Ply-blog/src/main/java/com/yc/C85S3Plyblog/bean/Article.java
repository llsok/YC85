package com.yc.C85S3Plyblog.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

public class Article implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String author;
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	private String keywords;
	private String description;
	@NotEmpty
	private Integer categoryid;
	@NotEmpty
	private String label;
	private String titleimgs;
	private String status;
	private Timestamp createtime;
	private Integer readcnt;
	private Integer agreecnt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getTitleimgs() {
		return titleimgs;
	}
	public void setTitleimgs(String titleimgs) {
		this.titleimgs = titleimgs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(Integer readcnt) {
		this.readcnt = readcnt;
	}
	public Integer getAgreecnt() {
		return agreecnt;
	}
	public void setAgreecnt(Integer agreecnt) {
		this.agreecnt = agreecnt;
	}
	
}
