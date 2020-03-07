package com.yc.api.d0305;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yc.api.d0229.NameHelper;

public class StudentManage {

	ArrayList<Student> stuList = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		StudentManage sm = new StudentManage();
		
		//sm.createStudent();
		
		//sm.save();
		
		sm.load();
		
		sm.showStudents();
		
	}
	
	/**
	 * 	生成学生数据
	 */
	public void createStudent() {

		// ArrayList<Student> stuList = new ArrayList<Student>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Random random = new Random();

		int count = stuList.size();
		
		for (int i = 0; i < 100; i++) {
			// 生成姓名
			String name = NameHelper.createName();
			// 生成编号
			String istr = "" + (count + i + 1); // 转字符串
			istr = "00" + istr;
			istr = istr.substring( istr.length() - 3 , istr.length());  // 截取倒数第三位 到 最后 的字符串
			String sn = sdf.format(date) + istr; // 20200303    001 0011 00456
			// 随机成功三科成绩
			int chinese = random.nextInt(71) + 30;
			int math = random.nextInt(71) + 30;
			int physics = random.nextInt(71) + 30;
			Student s = new Student(name, sn, chinese, math, physics);
			
			Parent p = new Parent(NameHelper.createName(),"13800001111",40);
			s.setParent(p);
			
			stuList.add(s);
		}
	}
	
	/**
	 * 	将学生信息存储到文件中
	 */
	public void save() {
		// 以二进制( 字节流 )方式保存数据
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// 创建文件输出字节流
			boolean append = true;  // append 追加
			fos = new FileOutputStream("d:/student.dat",append);
			oos = new ObjectOutputStream(fos);// oos 是处理流
			// 使用对象流进行输出 ==> ObjectOutputStream?
			/**
			 * 	java.io.NotSerializableException: com.yc.api.d0305.Student
			 * 	Student 未实现 序列化 接口,   出现该异常 说明 有一个未被序列化的 对象 被流输入或输出
			 */
			oos.writeObject(stuList.clone());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOHelper.close(fos);
			IOHelper.close(oos);
		}
	}
	
	/**
	 * 	从文件中读入学生信息
	 */
	@SuppressWarnings("unchecked")   // @ 注解 
	public void load() {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("d:/student.dat");
			ois = new ObjectInputStream(fis);
			/**
			 * Unhandled exception type ClassNotFoundException
			 *  Class Not Found 类型没有找到
			 */
			ArrayList<Student> stuList = null;
			
			do {
				stuList = (ArrayList<Student>) ois.readObject();
				if(stuList != null) {
					this.stuList.addAll(stuList);
				}
			} while( stuList != null);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOHelper.close(fis);
			IOHelper.close(ois);
		}
	}
	
	public void showStudents() {
		for(Student s : stuList) {
			System.out.println(s);
		}
	}
	
	
	/**
	 * 	扩展需求:
	 * 1, 创建一个 Parent 家长 类:   姓名,  电话, 年龄,  取值随机
	 * 2.为每个学生添加一个家长的成员变量, 并赋值一个家长对象
	 * 3.查API,实现文件数据的追加
	 * 4.追加的学生信息的学号, 要递增
	 */

	
}
