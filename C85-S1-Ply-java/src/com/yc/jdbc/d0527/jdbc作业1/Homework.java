package ycjdbc0320;

import java.sql.*;
import java.util.Scanner;

import studentutil.IOhelp;

public class Homework {
	/**
	 * 创建表
	 */
	public void createtable() {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "create table porduct(productcode int primary key,pname varchar2(32),quantity int)";
			stat.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}
	}

	/**
	 * 插入数据
	 * 
	 * @param productcode
	 * @param pname
	 * @param quentity
	 */
	public void insertdate(int productcode, String pname, int quentity) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "insert into porduct values(?,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, productcode);
			stat.setString(2, pname);
			stat.setInt(3, quentity);
			stat.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 检查数据
	 * 
	 * @param pname
	 */
	public void checkdate(String pname) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from porduct ";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				int porductcode = rs.getInt("PRODUCTCODE");
				String name = rs.getString("PNAME");
				int quentity = rs.getInt("QUANTITY");
				if (pname.equals(name)) {
					System.out.println("已存在此产品，请更改产品数量");
					System.out.println("原来的数量为" + quentity);
				} else {

				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 删除数据
	 * 
	 * @param pname
	 */
	public void deletedate(int productcode) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "delete  from porduct where productcode=? ";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, productcode);
			stat.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 根据产品名称删除多条数据
	 */
	public void deletesdate(String name1, String name2) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "delete  from porduct where pname =? or pname=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name1);
			stat.setString(2, name2);
			stat.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 遍历数据
	 */
	public void query() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "select *  from porduct  ";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				int porductcode = rs.getInt("PRODUCTCODE");
				String name = rs.getString("PNAME");
				int quentity = rs.getInt("QUANTITY");
				System.out.printf("产品编号：%s\t产品名称：%s\t产品数量：%s\t\n", porductcode, name, quentity);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 查找数据
	 * 
	 * @param pname
	 */
	public void querydate(String pname) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "select *  from porduct where pname=? ";
			stat = conn.prepareStatement(sql);
			stat.setString(1, pname);
			rs = stat.executeQuery();
			while (rs.next()) {
				int porductcode = rs.getInt("PRODUCTCODE");
				String name = rs.getString("PNAME");
				int quentity = rs.getInt("QUANTITY");
				System.out.printf("产品编号：%s\t产品名称：%s\t产品数量：%s\t\n", porductcode, name, quentity);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 修改数据
	 * 
	 * @param pname
	 */
	public void update(int productcode, String pname, int quentity) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "update porduct set pname=?,quantity= ? where productcode=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, pname);
			stat.setInt(2, quentity);
			stat.setInt(3, productcode);
			stat.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 分页查询 select * from( select rownum as rn,productcode,pname,quantity from
	 * (select * from porduct) where rownum<=5) where rn>=1;
	 * 
	 * @param string
	 */
	public void selectdate(int max, int min) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "select * from(\r\n" + "select rownum as rn,productcode,pname,quantity\r\n"
					+ "from (select * from porduct)\r\n" + "where rownum<=?)\r\n" + "where rn>=? ";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, max);
			stat.setInt(2, min);
			rs = stat.executeQuery();
			while (rs.next()) {
				int rn = rs.getInt("RN");
				int porductcode = rs.getInt("PRODUCTCODE");
				String name = rs.getString("PNAME");
				int quentity = rs.getInt("QUANTITY");
				System.out.printf("RN:%s\t产品编号：%s\t产品名称：%s\t产品数量：%s\t\n", rn, porductcode, name, quentity);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 模糊查询
	 * 
	 * @param args
	 */

	public void querylikedate(String string) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "select *  from porduct where pname like ? ";
			stat = conn.prepareStatement(sql);
			stat.setString(1, string);
			rs = stat.executeQuery();
			while (rs.next()) {
				int porductcode = rs.getInt("PRODUCTCODE");
				String name = rs.getString("PNAME");
				int quentity = rs.getInt("QUANTITY");
				System.out.printf("产品编号：%s\t产品名称：%s\t产品数量：%s\t\n", porductcode, name, quentity);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	/**
	 * 根据编号精确查找
	 * 
	 * @param args
	 */
	public void querydate(int productcode) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "select *  from porduct where productcode=? ";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, productcode);
			rs = stat.executeQuery();
			while (rs.next()) {
				int porductcode = rs.getInt("PRODUCTCODE");
				String name = rs.getString("PNAME");
				int quentity = rs.getInt("QUANTITY");
				System.out.printf("产品编号：%s\t产品名称：%s\t产品数量：%s\t\n", porductcode, name, quentity);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String pname = null;
		Homework h = new Homework();
		// h.createtable();
		for (int k=0;;k++) {
			System.out.println("是否查看数据：Y/N");
			String cc = s.next();
			if (cc.equals("Y")) {
				h.query();
				for (int k1=0;;k1++) {
					System.out.println("你可进行如下操作:");
					System.out.println("1.插入2.删除3.分页查询4.多项删除5.产品名查询6.产品编号查询7.修改8.模糊查询9.退出");
					String c = s.next();
					if (c.equals("插入")) {
						System.out.println("请输入产品名");
						pname = s.nextLine();
						h.checkdate(pname);
						System.out.println("请输入产品数量：");
						int quantity = s.nextInt();
						System.out.println("请输入产品编号");
						int i = s.nextInt();
						h.insertdate(i, pname, quantity);
						System.out.println("插入成功");
					} else if (c.equals("删除")) {
						System.out.println("请输入需要删除的产品编号");
						int a = s.nextInt();
						h.deletedate(a);
						System.out.println("删除成功");
					} else if (c.equals("分页查询")) {
						System.out.println("请输入分页的最大编号");
						int a1 = s.nextInt();
						System.out.println("请输入分页的最小编号");
						int a2 = s.nextInt();
						h.selectdate(a1, a2);
					} else if (c.equals("多项删除")) {
						System.out.println("请输入需要删除的产品名称1");
						String s1 = s.next();
						System.out.println("请输入需要删除的产品名称2");
						String s2 = s.next();
						h.deletesdate(s1, s2);
						System.out.println("删除成功");
					} else if (c.equals("产品名查询")) {
						System.out.println("请输入需要查找的产品名");
						pname = s.nextLine();
						h.querydate(pname);
					} else if (c.equals("产品编号查询")) {
						System.out.println("请输入需要查找的产品编号");
						int a = s.nextInt();
						h.querydate(a);
					} else if (c.equals("修改")) {
						System.out.println("请输入需要修改的产品编号");
						int num = s.nextInt();
						System.out.println("修改产品名称为：");
						pname = s.next();
						System.out.println("修改产品数量为：");
						int quantity = s.nextInt();
						h.update(num, pname, quantity);
						System.out.println("修改成功");
					} else if (c.equals("模糊查询")) {
						System.out.println("请输入需要查找的产品名       例如：苹_  ");
						pname = s.nextLine();
						h.querylikedate(pname);
					} else if (c.equals("退出")) {
						break;
					}

				}
			} else if (cc.equals("N")){
				break;
			}
		}

	}

}
