package com.yc.web.d0530;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.web.util.DBHelper;

public class SsqDao {
	
	/**
	 * 将双色球的文件数据写入数据库
	 * @param filename
	 * 
	 * E:\dev\apache-tomcat-8.5.54\wtpwebapps\C85-S2-Ply-web\0530
	 * @throws IOException 
	 */
	public void insert(String filename) throws IOException {
		System.out.println("开始");
		// 字符文件  ==>  FileReader\   文件流 => 资源流
		FileReader fr = new FileReader(filename);
		// 缓冲流   => 处理流
		BufferedReader br = new BufferedReader(fr);
		// 定义保存行数据的字符串
		String line = null;
		DBHelper dbh = new DBHelper();
		//String sql = "insert into lottery values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		//String batchSql = "insert into lottery values (...), (...),(...),(...)";
		// mysql 批量新增
		StringBuilder sb = new StringBuilder("insert into lottery values");
		List<Object> params = new ArrayList<>();
		while(   (  line = br.readLine()  ) !=null  ) {
			// 拼接 sql 语句
			sb.append("(null,?,?,?,?,?,?,?,?,?,?,?,?),");
			String[] arr = line.split("\\s+");
			// 添加参数
			for(String s : arr) {
				params.add(s);
			}
		}
		// 截取sql, 去掉最后的,号
		dbh.update(sb.toString().substring(0, sb.length()-1), params.toArray());
		System.out.println("结束");
		br.close();
		
	}
	
	public List<Map<String,Object>> queryAll(){
		return new DBHelper().query("select * from lottery");
	}
	
	/**
	 * 分页查询
	 * @param page  页号
	 * @param size	每页行数
	 * @return
	 * limit 第几行, 查几条记录
	 */
	public List<Map<String,Object>> queryPage(int page, int size){
		int begin = (page - 1) * size;
		return new DBHelper().query("select * from lottery limit ?, ?", begin, size);
	}
	
	/**
	 * 统计总页数
	 * @return
	 */
	public int countPages(int size) {
		return new DBHelper().count("select * from lottery") / size;
	}
	
	public static void main(String[] args) throws IOException {
		String filename = "E:/双色球.txt";
		new SsqDao().insert(filename);
	}


}
