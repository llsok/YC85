package com.yc.library.bean;

import java.sql.Timestamp;

public class Lend implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Integer bid;
	private String person;
	private Timestamp lendtime;
	private Timestamp rettime;
	private String remark;
	private Integer eid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Timestamp getLendtime() {
		return lendtime;
	}
	public void setLendtime(Timestamp lendtime) {
		this.lendtime = lendtime;
	}
	public Timestamp getRettime() {
		return rettime;
	}
	public void setRettime(Timestamp rettime) {
		this.rettime = rettime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lend other = (Lend) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Lend [id=" + id + ", bid=" + bid + ", person=" + person + ", lendtime=" + lendtime + ", rettime="
				+ rettime + ", remark=" + remark + ", eid=" + eid + "]";
	}
	
}
