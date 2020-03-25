package com.yc.jdbc.d0322;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.yc.api.d0305.IOHelper;

/**
 *	JDBC : java 数据库连接组件 
 * 	JDBC = API  + SPI(驱动jar)
 * 	
 * 	五步操作:
 * 	1, 加载驱动 : Class.forName("驱动类类路径");
 * 	2, 获取连接 : DriverManager.getConnection(url, username, password); 
 * 	3, 创建语句对象
 * 		Statement stat = conn.createStatement(); //  普通语句对象, 不传入sql
 * 		PreparedStatement ps = conn.perpareStatement(sql); //预编译语句对象, 传sql
 * 		预编译语句对象的优势:
 * 		1, 预防注入攻击
 * 			基于 sql 语句的拼接
 * 			sql = "select * from 表 where 字段='" + 值 + "'"  ;  值 = ' or '1' = '1
 * 		2, 效率高
 * 4, 执行语句
 * 		预编译语句对象: 要在查询前设置参数值  setXXX
 * 		executeUpdate ==> DML 增删改     DDL 建表\索引
 * 		executeQuery  ==> select	
 * 			ResultSet ==> getXXX(  列索引 1~N    列名(Oracle 使用大写列名) ) 获取字段值
 * 5, 关闭连接
 * 		结果集  ResultSet \ Statement  \ Connection   ==> 
 * 		Connection.close() 连接的关闭, 会连同其创建语句对象和结果集一同关闭
 * 
 * 
 * 数据库中的日期类型
 * 	Date ==> 年月日  1999.1.1   不带时分秒			==> java.sql.Date		父类: java.util.Date
 * 	datetime, timestamp  表示时间:年月日时分秒		==> java.sql.Timestamp	父类: java.util.Date
 * 
 * 
 * JDBC高级操作
 * 1, 结果集封装	实体类:用于保存数据的类(c 结构体), 和数据的表形成对应关系
 * 2, 组合条件查询 
 * 3, 日期条件构建
 * 4, 分页查询
 * 5, 事务管理
 * 
 */
public class Demo1 {

	/**
	 * 根据部门编号查 部门信息
	 * @param no
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Dept selectDeptByNo(String no) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
			String user = "scott"; // 数据的用户
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from dept where deptno = ?";
			// 创建预编译语句对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 查询查询参数
			ps.setString(1, no);
			// 执行语句
			ResultSet rs = ps.executeQuery();
			// 移动游标
			if (rs.next()) {
				// 创建返回结构
				Dept d = new Dept();
				// 映射 字段值 映射 属性值
				d.setDeptno(rs.getInt("DEPTNO"));
				d.setDname(rs.getString("DNAME"));
				d.setLoc(rs.getString("LOC"));
				return d;
			} else {
				// 没有查到结构,返回 null
				return null;
			}
		} finally {
			IOHelper.close(conn);
		}
	}

	/**
	 * 
	 * @param emp		查询条件
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Emp> selectEmp(Emp emp, Date beginDate, Date endDate) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
			String user = "scott"; // 数据的用户
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			/**
			 *  动态组合条件 ==> sql 的动态拼接
			 *  emp 所有属性为空 (无条件) 查询所有记录 ==> select * from emp where 1=1
			 *  emp.name 有值	(名称有值) ==> select * from emp where name = ?
			 *  emp.name, deptno 有值 ==> select * from emp where name = ? and deptno=?
			 *  emp.deptno 有值		==> select * from emp where deptno=?
			 */
			// 使用集合来存储查询的参数
			List<Object> paramList = new ArrayList<>();
			String sql = "select * from emp where 1=1";
			if (emp.getEname() != null) {
				sql += " and ename = ?";
				paramList.add(emp.getEname());
			}
			if (emp.getDeptno() != null) {
				sql += " and deptno = ?";
				paramList.add(emp.getDeptno());
			}
			// 加入日期查询条件
			/*if (emp.getHiredate() != null) {
				sql += " and hiredate = ?";
				paramList.add(emp.getHiredate());
			}*/
			// 查时间区间
			sql += " and hiredate between ? and ?";
			paramList.add(beginDate);
			paramList.add(endDate);
			
			// 在执行之前请打印sql语句
			System.out.println("sql : " + sql);
			
			// 创建预编译语句对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 添加查询参数
			for(int i=0; i<paramList.size();i++) {
				// Object 类型 可以使用  setObject
				ps.setObject(i+1, paramList.get(i));
			}
			// 执行语句
			ResultSet rs = ps.executeQuery();
			// 创建返回结果
			List<Emp> ret = new ArrayList<>();
			// 移动游标
			while (rs.next()) {
				// 创建返回结构
				Emp e = new Emp();
				// 映射 字段值 映射 属性值
				e.setDeptno(rs.getInt("DEPTNO"));
				e.setEname(rs.getString("ENAME"));
				// java.sql.SQLException: 无法转换为内部表示    字段类型错误
				// e.setEmpno(rs.getInt("ENAME"));
				e.setEmpno(rs.getInt("EMPNO"));
				e.setHiredate(rs.getDate("HIREDATE"));
				// 请补齐剩下的字段映射
				ret.add(e);
			}
			return ret;
		} finally {
			IOHelper.close(conn);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Demo1 demo1 = new Demo1();
		Dept d = demo1.selectDeptByNo("60");
		System.out.println(d);
		
		// 组合条件查询测试
		Emp emp = new Emp();
		//System.out.println(demo1.selectEmp(emp));
		
		// 加入日期条件
		// 当前的时间 2020
		//Date date = new Date(System.currentTimeMillis());
		//Date date = Date.valueOf("1987-4-19");
		//emp.setHiredate(date);
		//System.out.println(demo1.selectEmp(emp));
		
		//emp.setDeptno(10);
		//System.out.println(demo1.selectEmp(emp));
		//emp.setEname("zhangsan");
		//System.out.println(demo1.selectEmp(emp));
		
		/**
		 * 根据时间区间查记录
		 */
		Date beginDate = Date.valueOf("1981-1-1");
		Date endDate = Date.valueOf("1981-12-31");
		List<Emp> list = demo1.selectEmp(emp, beginDate , endDate);
		for(Emp e : list) {
			System.out.println(e);
		}

	}

}
