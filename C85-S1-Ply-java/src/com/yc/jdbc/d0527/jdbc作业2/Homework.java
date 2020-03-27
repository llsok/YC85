package ycjdbc0323;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import studentutil.Agehelp;

import studentutil.IOhelp;
import studentutil.Majorhelp;
import studentutil.Namehelp;
import studentutil.Sexhelp;

public class Homework {
	/**
	 * 创建students表
	 */
	public void createtable() {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "create table students(   sn int primary key,  sname varchar2(20),  sex varchar2(4), major varchar2(30) , birday Date,inschooldate Date,   graduationstatus varchar2(10))";
			stat = conn.prepareStatement(sql);
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
	 * 插入数据
	 * 
	 * @param args
	 */
	public void insert(int sn, String sname, String sex, String major, Date birday, Timestamp inschooldate, 
			String graduationstatus) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into students values( ?,  ?,  ?, ? ,  ?, ?,   ?)";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, sn);
			stat.setString(2, sname);
			stat.setString(3, sex);
			stat.setString(4, major);
			stat.setDate(5, birday);
			stat.setTimestamp(6, inschooldate);
			stat.setString(7, graduationstatus);
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
	 * 组合查询
	 * 
	 * @param args
	 */
	public List<Students> select(Students s) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from students where 1=1";
			List<Object> paramlist = new ArrayList<>();
			if (s.getSn() != null) {
				sql += " and sn=?";
				paramlist.add(s.getSn());
			}
			if (s.getBirday() != null) {
				sql += " and birday=?";
				paramlist.add(s.getBirday());
			}
			if (s.getGraduationstatus() != null) {
				sql += " and graduationstatus=?";
				paramlist.add(s.getGraduationstatus());
			}
			if (s.getInshcooldate() != null) {
				sql += " and inschooldate=?";
				paramlist.add(s.getInshcooldate());
			}
			if (s.getMajor() != null) {
				sql += " and major=?";
				paramlist.add(s.getMajor());
			}
			if (s.getSex() != null) {
				sql += " and sex=?";
				paramlist.add(s.getSex());
			}
			if (s.getSname() != null) {
				sql += " and sname=?";
				paramlist.add(s.getSname());
			}
			System.out.println("sql:" + sql);
			stat = conn.prepareStatement(sql);

			for (int i = 0; i < paramlist.size(); i++) {
				stat.setObject(i + 1, paramlist.get(i));
			}

			ResultSet rs = stat.executeQuery();
			List<Students> list = new ArrayList<>();
			while (rs.next()) {
				Students student = new Students();
				student.setSn(rs.getInt("SN"));
				student.setSname(rs.getString("SNAME"));
				student.setSex(rs.getString("SEX"));
				student.setMajor(rs.getString("MAJOR"));
				student.setBirday(rs.getDate("BIRDAY"));
				student.setInshcooldate(rs.getTimestamp("INSCHOOLDATE"));
				student.setGraduationstatus(rs.getString("GRADUATIONSTATUS"));
				list.add(student);
			}
			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}
		return null;

	}

	/**
	 * 时间区间查询
	 * 
	 * @param args
	 */
	public List<Students> selectdate(Date begin, Date end) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from students where 1=1 and inschooldate between ? and ?";
			stat = conn.prepareStatement(sql);
			stat.setDate(1, begin);
			stat.setDate(2, end);
			List<Students> list = new ArrayList<>();
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Students student = new Students();
				student.setSn(rs.getInt("SN"));
				student.setSname(rs.getString("SNAME"));
				student.setSex(rs.getString("SEX"));
				student.setMajor(rs.getString("MAJOR"));
				student.setBirday(rs.getDate("BIRDAY"));
				student.setInshcooldate(rs.getTimestamp("INSCHOOLDATE"));
				student.setGraduationstatus(rs.getString("GRADUATIONSTATUS"));
				list.add(student);
			}
			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}
		return null;

	}

	/**
	 * 指定年份查询
	 * 
	 * @param args
	 */
	public List<Students> selecttime(int year) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from students where to_char(inschooldate,'yyyy')=? ";
			stat = conn.prepareStatement(sql);
			String s = String.valueOf(year);
			stat.setString(1, s);
			List<Students> list = new ArrayList<>();
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Students student = new Students();
				student.setSn(rs.getInt("SN"));
				student.setSname(rs.getString("SNAME"));
				student.setSex(rs.getString("SEX"));
				student.setMajor(rs.getString("MAJOR"));
				student.setBirday(rs.getDate("BIRDAY"));
				student.setInshcooldate(rs.getTimestamp("INSCHOOLDATE"));
				student.setGraduationstatus(rs.getString("GRADUATIONSTATUS"));
				list.add(student);
				
			}
			
			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			IOhelp.close(stat);
			IOhelp.close(conn);
		}
		return null;

	}
	/**
	 * 学号查找
	 * @param sn
	 */
	public void findsn(int sn) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql="select * from students where sn=?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1, sn);
			ResultSet rs=stat.executeQuery();
			while(rs.next()) {
				int sid=rs.getInt("SN");
				String sname=rs.getString("SNAME");
				String sex=rs.getString("SEX");
				String major=rs.getString("MAJOR");
				Date birday=rs.getDate("BIRDAY");
				Date inschooldate=rs.getDate("INSCHOOLDATE");
				String graduationstatus=rs.getString("GRADUATIONSTATUS");
				System.out.printf("学号：%s  姓名：%s  性别：%s  专业：%s  出生日期：%s  入学日期：%s  毕业状态：%s\n",sid,sname,sex,major,birday,inschooldate,graduationstatus);
				
				java.util.Date d=new java.util.Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
				String s1=sdf.format(inschooldate);
				String s2=sdf.format(d);
				int i1=Integer.valueOf(s1);
				int i2=Integer.valueOf(s2);
				if(i2-i1>=3) {
					System.out.println("你已经达到毕业要求"); 
				}else {
					System.out.println("你没达到毕业要求");
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
	 * 数据修改
	 * @param sn
	 */
	public void update(String s,int sn) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql="update  students set graduationstatus=?  where sn=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1, s);
			stat.setInt(2, sn);
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

	public static void main(String[] args) {
		Random random=new Random();
		Homework h = new Homework();
		// 建表
		// h.createtable();
		// 插入1000条数据
		/*
		 * for (int i = 0; i < 1000; i++) { h.insert(i + 1,
		 * Namehelp.creatName(),Sexhelp.createsex(), Majorhelp.createmajor(),
		 * Agehelp.createbirday(Agehelp.createDate()),Agehelp.createDate(),
		 * Agehelp.creategraduationstatus()); }
		 */
		 
		
		  //名字查询 
		
		  Students s=new Students(); s.setSname("姬文尔");
		  System.out.println(h.select(s));
		 
		 
		 

		
		/*
		 * //时间区间找人 Date begin=Date.valueOf("2013-01-01"); Date
		 * end=Date.valueOf("2014-12-31"); List<Students> list=h.selectdate(begin, end);
		 * for(Students stu:list) { System.out.println(stu); }
		 */
		
		
		  //指定年份找人 
		
		/*
		 * List<Students>list=h.selecttime(2016); for(Students stu:list) {
		 * System.out.println(stu); }
		 */
		 
		//修改毕业状态
		/*
		 * h.findsn(100); h.update("已毕业", 100);h.findsn(100);
		 */
		 
		
		
	}

}
