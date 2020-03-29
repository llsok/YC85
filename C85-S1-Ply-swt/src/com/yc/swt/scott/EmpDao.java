package com.yc.swt.scott;

import java.util.*;

public class EmpDao {
	/**
	 * 	引入Oracle 驱动
	 */
	
	public List<Map<String,Object>> selectAll(){
		return new DBHelper().query("select * from emp");
	}
}
