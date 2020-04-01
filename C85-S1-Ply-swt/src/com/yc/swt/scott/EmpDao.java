package com.yc.swt.scott;

import java.util.*;

public class EmpDao {
	/**
	 * 	引入Oracle 驱动
	 */
	
	public List<Map<String,Object>> selectAll(){
		return new DBHelper().query("select * from emp");
	}
	
	/**
	 * 	组合条件查询
	 * @param emp 存放查询条件的实体对象
	 * @return
	 */
	public List<Map<String,Object>> selectByObject(Emp emp){
		
		String sql = "select * from emp where 1=1";
		// 参数数组
		ArrayList<Object> params = new ArrayList<>();
		/**
		 * trim() 去空格
		 * isEmpty() 判断是否为空字符串(  0字节字符串,  非 null )
		 */
		if(emp.getEname()!=null && emp.getEname().trim().isEmpty() == false) {
			sql += " and ename like ?";
			params.add("%" + emp.getEname() + "%");
		}
		if(emp.getJob()!=null && emp.getJob().trim().isEmpty() == false) {
			sql += " and job like ?";
			params.add("%" + emp.getJob() + "%");
		}
		return new DBHelper().query(sql, params.toArray());
		
	}
}
