package com.yc.jdbc.d0319;

// jdbc 的包
import java.sql.*;

import com.yc.api.d0305.IOHelper;

/**
 * JDBC: java 数据库连接组件 ( 一系列 操作的数据的 接口和类 , 包 java.sql)
 * 1. 加载驱动	Class.forName("类路径")
 * 2. 获取连接 getConnection(url, user, password)
 * 3. 创建语句  createStatement()  prepareStatment(sql);
 * 4. 执行语句
 * 5. 关闭连接
 */
public class Demo1 {

	public void updateDept() throws ClassNotFoundException, SQLException {
		// JDBC 编程: 5个步骤
		// 1.加载驱动 ==> 类的类
		// 获取类对象的方式
		// 1. Demo1.class
		// 2. Demo1 a; a.getClass();
		// 3. Class.forName();
		// Class.forName("驱动类的类路径(类的完全限定名 = 包名 + 类名)");
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.获取连接
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
		String user = "scott"; // 数据的用户
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);

		// 3.创建语句
		Statement stat = conn.createStatement();

		// 4.执行语句
		String sql = "update dept set dname='财务部' where deptno=60";
		// stat.executeUpdate("数据库的修改操作: insert update delete create ");
		// stat.executeQuery("查询");
		int ret = stat.executeUpdate(sql);
		System.out.println("更新了" + ret + "条记录");
		// 5.关闭连接
		stat.close(); // 关闭语句对象
		conn.close(); // 关闭连接对象
		// 请在 dept 新增一个 人力部

	}

	public void selectBySal() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
			String user = "scott"; // 数据的用户
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "select * from emp where sal > 1000";

			// 执行sql ResultSet 是查询的结果对象, 它也需要关闭
			rs = stat.executeQuery(sql); // 异常
			// rs.next() 判断结果集中是否还有数据, 返回 boolean 值
			while (rs.next()) {
				int empno = rs.getInt(1); // get数据类型 用于获取指定的字段值, 字段索引从 1 开始计数
				String ename = rs.getString(2);
				String job = rs.getString("JOB"); // oracle 字段名会自动转成大写
				double sal = rs.getDouble("SAL");
				System.out.printf("%s\t%s\t%s\t%s\t\n", empno, ename, job, sal);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭一定要在 finally 中
			IOHelper.close(rs);
			IOHelper.close(stat);
			IOHelper.close(conn);
		}
	}

	// 方法重载
	/**
	 * 预编译语句对象:
	 * 1. 是普通语句对象的子类
	 * 2. 使用 ? 占位符替代参数
	 * 3. 创建语句对象使用 prepareStatment
	 * 4. 使用 setXXX 方法设置 sql 参数
	 * 5. 执行语句不用传入 sql 语句
	 * @param name
	 */
	public void selectByName(String name) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 数据库的地址
			String user = "scott"; // 数据的用户
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			/**
			 * stat = conn.createStatement();
			 */
			
			/**
			 * 使用预编译的语句对象执行 sql ,那么 sql 中参数 请使用个  ? (英文的) 替代参数 ,  占位符
			 */
			String sql = "select * from emp where ename = ?";
			System.out.println(sql);
			
			/**
			 * 在创建语句时, 使用预编译语句对象, 并且在创建的那一刻将sql 语句传入
			 */
			stat = conn.prepareStatement(sql);

			// 执行sql ResultSet 是查询的结果对象, 它也需要关闭
			/**
			 * 在执行语句前, 使用 setXXX 方法将参数传入sql, 占位符使用索引表示位置, 索引从1 开始计数
			 */
			stat.setString(1,name);
			/**
			 * 执行预编译语句对象时, 就不需要在传 sql 了
			 */
			rs = stat.executeQuery(); // 异常
			
			// rs.next() 判断结果集中是否还有数据, 返回 boolean 值
			while (rs.next()) {
				int empno = rs.getInt(1); // get数据类型 用于获取指定的字段值, 字段索引从 1 开始计数
				String ename = rs.getString(2);
				String job = rs.getString("JOB"); // oracle 字段名会自动转成大写
				double sal = rs.getDouble("SAL");
				System.out.printf("%s\t%s\t%s\t%s\t\n", empno, ename, job, sal);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭一定要在 finally 中
			IOHelper.close(rs);
			IOHelper.close(stat);
			IOHelper.close(conn);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Demo1 d1 = new Demo1();

		// d1.updateDept();
		// 注入攻击的
		d1.selectByName("abc' or '1'='1");
		d1.selectByName("SMITH");
		d1.selectByName("JONES");
	}

}
