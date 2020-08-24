package com.yc.C85S3Plyblog.bean;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="昵称不能为空!")
	@Length(min=4,max=20,message="昵称必须是4~20位")
	private String name;
	@NotEmpty(message="账号不能为空!")
	@Length(min=4,max=20,message="账号必须是4~20位")
	private String account;
	@NotEmpty(message="密码不能为空!")
	@Length(min=4,max=20,message="密码必须是4~20位")
	private String pwd;
	private String phone;
	@Email(message="邮箱格式错误")
	private String email;
	private String head;
	private Timestamp createtime;
	private String status;
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
