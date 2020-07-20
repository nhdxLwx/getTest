package com.libsys.entity;

//该表为BookInfo和TypeInfo联合查询的表
public class BookAndType {
	private int bid;			//图书编号
	private String bname;		//图书名称
	private String tname;			//图书类型
	private String author;		//作者
	private double price;		//价格
	
	public BookAndType(int bid, String bname, String tname, String author, double price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.tname = tname;
		this.author = author;
		this.price = price;
	}
	public BookAndType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
