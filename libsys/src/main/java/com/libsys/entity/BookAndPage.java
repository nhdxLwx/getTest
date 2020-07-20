package com.libsys.entity;

public class BookAndPage {
	private int bid;			//图书编号
	private String bname;		//图书名称
	private int tid;			//图书类型
	private String author;		//作者
	private double price;		//价格
	private Integer currentPage;//当前页
    private Integer perPageRows;//每页的记录数
    private Integer totalRows;//总记录数：
    private Integer totalPages;//总页数：
	@Override
	public String toString() {
		return "BookAndPage [bid=" + bid + ", bname=" + bname + ", tid=" + tid + ", author=" + author + ", price="
				+ price + ", currentPage=" + currentPage + ", perPageRows=" + perPageRows + ", totalRows=" + totalRows
				+ ", totalPages=" + totalPages + "]";
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
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPerPageRows() {
		return perPageRows;
	}
	public void setPerPageRows(Integer perPageRows) {
		this.perPageRows = perPageRows;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
}
