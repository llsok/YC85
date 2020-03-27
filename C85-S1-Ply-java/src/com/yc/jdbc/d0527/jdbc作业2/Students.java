package ycjdbc0323;

import java.sql.Timestamp;
import java.util.Date;

public class Students {
	private Integer sn;
	private String sname;
	private String sex;
	private String major;
	private Date birday;
	private Timestamp inshcooldate;
	private String graduationstatus;
	
	
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Date getBirday() {
		return birday;
	}
	public void setBirday(Date birday) {
		this.birday = birday;
	}
	
	public Timestamp getInshcooldate() {
		return inshcooldate;
	}
	public void setInshcooldate(Timestamp inshcooldate) {
		this.inshcooldate = inshcooldate;
	}
	public String getGraduationstatus() {
		return graduationstatus;
	}
	public void setGraduationstatus(String graduationstatus) {
		this.graduationstatus = graduationstatus;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sn;
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
		Students other = (Students) obj;
		if (sn != other.sn)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Students [sn=" + sn + ", sname=" + sname + ", sex=" + sex + ", major=" + major + ", birday=" + birday
				+ ", inshcooldate=" + inshcooldate + ", graduationstatus=" + graduationstatus + "]";
	}
	
	
	
	
	

}
