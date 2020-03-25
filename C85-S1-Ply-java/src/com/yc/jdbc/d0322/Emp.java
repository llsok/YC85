package com.yc.jdbc.d0322;

import java.sql.Date;

/**
 * 员工表的实体类
 * @author 廖彦
 *
 */
public class Emp {
	
	private Integer empno;
	private String ename;
	private String job;
	private String mgr;
	private Double sal;
	private Double comm;
	private Integer deptno;
	
	/**
	 * 数据库中的日期类型
	 * 	Date ==> 年月日  1999.1.1   不带时分秒			==> java.sql.Date		父类: java.util.Date
	 * 	datetime, timestamp  表示时间:年月日时分秒		==> java.sql.Timestamp	父类: java.util.Date
	 */
	private Date hiredate;
	
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empno == null) ? 0 : empno.hashCode());
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
		Emp other = (Emp) obj;
		if (empno == null) {
			if (other.empno != null)
				return false;
		} else if (!empno.equals(other.empno))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", sal=" + sal + ", comm="
				+ comm + ", deptno=" + deptno + ", hiredate=" + hiredate + "]";
	}
}
