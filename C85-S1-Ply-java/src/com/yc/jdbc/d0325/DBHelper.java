package com.yc.jdbc.d0325;

import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import com.yc.api.d0305.IOHelper;

/**
 * 	结果集封装
 * 		实体类 	==> 	表
 * 		一个对象    	==>  	一条记录
 * 		属性		==>		字段
 * 				映射
 * 	组合条件查询
 * 		基于sql语句的动态的拼接条件
 * 		1. 	where 1=1 ==> 无用的查询条件, 方便拼接sql语句
 * 		2. 	使用List集合保存查询参数
 * 
 * 	日期类型
 * 		Date  ==>  年月日	==> java.sql.Date	---> 父类 java.util.Date
 * 		datetime   年月日时分秒  ==> java.sql.Timestamp --> 父类 java.util.Date
 * 		timestamp
 * 
 * 		java.sql.Date.valueOf("yyyy-MM-dd"); "20203-3-25";
 * 
 * 	分页查询
 * 
 * 	事务管理
 * 
 * 	DBHelper 封装 : 简化 jdbc 的代码
 * 	1.加载驱动	只加载一次 ==> 静态
 * 	2.获取连接
 * 	3.创建语句
 * 	4.执行语句
 * 	5.关闭连接
 * 
 * 	代码冗余 ==> 重复   ==> 提炼 ==> 代码精简
 * 
 * 	DBHelper 用于执行 sql 语句 返回对应的结果
 * 	1. 增删改  ==>  executeUpdate  ==> 返回: 数字  int , 增删改的行数
 * 	2. 查询     ==>  executeQuery	 ==> 返回:ResultSet, 
 * 		因为需要关闭, 应该返回实体类, 或者Map集合
 * 
 */
public class DBHelper {

	/**
	 * 	类的代码块:
	 * 	静态块: 
	 * 		static {}
	 * 		特点: 会在类被加载到虚拟机时,执行一次(  例如: import 类)
	 * 	实例块
	 * 		{}
	 * 		特点: 会在对象被创建时执行一次, 在构造方法前
	 * 	块不是方法,不能抛出编译期异常
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// 异常转型 ==> 异常链
			// 未捕获的运行期异常将导致程序的终止
			RuntimeException re = new RuntimeException("数据库驱动加载失败!", e);
			throw re;
		}
	}

	/**
	 * 	获取连接
	 * @return
	 */
	public Connection openConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
		String user = "scott"; // 数据的用户
		String password = "a";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException("获取数据库连接失败!", e);
		}
	}

	/**
	 * 	执行修改数据库的语句
	 * sql = "update emp set ename = ? where empno=?"
	 * update(sql,2,3,)
	 * @param sql		执行的sql语句
	 * @param params	可变参数数组
	 * @return
	 */
	public int update(String sql, Object... params) {
		Connection conn = openConnection();
		try {
			System.out.println("SQL: " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			// alrt + /
			System.out.println("参数: " + Arrays.toString(params));
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("执行SQL语句失败!", e);
		} finally {
			IOHelper.close(conn);
		}
	}

	/**
	 * 	执行查询语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> query(String sql, Object... params) {
		Connection conn = openConnection();
		try {
			System.out.println("SQL: " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			// alrt + /
			System.out.println("参数: " + Arrays.toString(params));
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ResultSet rs = ps.executeQuery();

			// 获取结果集元数据对象, 元(Meta)数据(data): 描述数据的数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 创建返回结果对象
			List<Map<String, Object>> ret = new ArrayList<>();
			while (rs.next()) {
				// 创建 map 集合
				/**
				 * 1. HashMap   	无序不重复
				 * 2 LinkedHashMap, 有序不重复
				 * 3. TreeMap 		排序不重复
				 */
				Map<String, Object> row = new LinkedHashMap<>();
				// 获取每一个字段值, 设置到一个map中
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(columnName);
					row.put(columnName, columnValue);
				}
				// 将 map 添加到 ret 中
				ret.add(row);
			}
			return ret;
		} catch (SQLException e) {
			throw new RuntimeException("执行SQL语句失败!", e);
		} finally {
			IOHelper.close(conn);
		}
	}

	/**
	 * 	分页查询: 翻书 
	 * @param sql
	 * @param pageNumber	第几页	=>  1,2,3 大于0
	 * @param pageSize		每页行数	=>  3,4 大于0
	 * @param params		可变参数数组: 只能放在最后一个参数位置
	 * @return
	 */
	public List<Map<String, Object>> queryPage(String sql, int pageNumber, int pageSize, Object... params) {
		// 参数顺序: 原参数数组 , 截止行数, 开始行数

		// number = 1, size = 5; => begin = 1, end =5
		// number = 2, size = 5; => begin = 6, end = 10
		// number = 2, size = 5; => begin = 11, end = 15

		int begin = (pageNumber - 1) * pageSize + 1;
		int end = pageNumber * pageSize;
		// 创建新参数数组
		Object[] newParams = new Object[params.length + 2];

		// 数组的复制: 1,引用复制, 2克隆复制 , 3 system.arraycopy
		System.arraycopy(params, 0, newParams, 0, params.length);

		// 给新的参数数组最后2个元素赋值
		newParams[newParams.length - 2] = end;
		newParams[newParams.length - 1] = begin;

		sql = "select *\n" + "  from (select a.*, rownum rn\n" + "          from (" + sql + ") a\n"
				+ "         where rownum <= ?)\n" + " where rn >= ? ";

		// 调用 query 查询方法
		return query(sql, newParams);
	}

	/**
	 * 	作业: 请返回该语句结果集的行数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int count(String sql, Object... params) {
		// select * from emp where ename like '%A%'
		// return query(sql, params).size();
		// 子查询 => select count(*) cnt from (select * from emp where ename like
		// '%A%') ;
		sql = "select count(*) from (" + sql + ")";
		Object cnt = query(sql, params).get(0).get("CNT");
		// Object ==> int   强制类型转换 ==> 类型匹配    String =>  int
		// int ret = (int) cnt; // 注定失败 cnt 类型是未知 ??   Integer Long BigDecimal 大实数
		int ret = Integer.valueOf("" + cnt);
		
		return ret;
	}

	/**
	 * 	作业: 返回结果集中, 第一行,第一列的值
	 * 	例如: select count(*) from emp;
	 * @return
	 */
	public Object getValue(String sql, Object...params) {
		List<Map<String,Object>> list = query(sql,params);
		Map<String,Object> row = list.get(0);
		for( Entry<String,Object> entry : row.entrySet() ) {
			return entry.getValue();
		}
		return null;
	}

	public static void main(String[] args) {

		DBHelper dbhelper = new DBHelper();

		// params = {1,2}
		// dbhelper.update("update dept set dname=? where deptno=?", "人力部", 60);
		// params = {1,2,3}
		// dbhelper.update("update dept set dname=?,loc=? where deptno=?",
		// "人力部", "衡阳", 60);
		// params = {}
		// dbhelper.update("update dept set dname='技术部',loc='师院' where
		// deptno=60");
		System.out.println("=========================");
		List<Map<String, Object>> list = dbhelper.query("select * from emp");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("=========================");
		list = dbhelper.query("select * from emp where ename like ?", "%S%");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("=========================");
		list = dbhelper.query("select * from emp where ename like ? " + " and sal > ? ", "%S%", 1250);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("==========1====5===========");
		list = dbhelper.queryPage("select * from emp", 1, 5);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("==========2====5===========");
		list = dbhelper.queryPage("select * from emp", 2, 5);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("==========3====5===========");
		list = dbhelper.queryPage("select * from emp", 3, 5);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("==========1====5====7521=======");
		list = dbhelper.queryPage("select * from emp where empno > ? ", 1, 5, 7521);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

}
