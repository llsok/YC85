package com.yc.spring.bank.bean;

public class Account implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer accountid;
	private String password;
	private Double balance;
	
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", password=" + password + ", balance=" + balance + "]";
	}
	
	

}
