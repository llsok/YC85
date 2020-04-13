package com.yc.library.bean;

import java.sql.Timestamp;

/**
 * 	图书实体类,  实体类必须实现序列化接口, 应为实体类有可能被流输入输出
 */
public class Book implements java.io.Serializable{

	/**
	 *  序列化版本编号
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String author;
	private String isbn;
	private String press;
	private Timestamp pressdate;
	private Byte status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Timestamp getPressdate() {
		return pressdate;
	}
	public void setPressdate(Timestamp pressdate) {
		this.pressdate = pressdate;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", isbn=" + isbn + ", press=" + press
				+ ", pressdate=" + pressdate + ", status=" + status + "]";
	}
	
}
