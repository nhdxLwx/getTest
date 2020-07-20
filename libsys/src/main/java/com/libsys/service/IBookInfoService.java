package com.libsys.service;

import java.util.List;

import com.libsys.entity.BookAndPage;
import com.libsys.entity.BookAndType;
import com.libsys.entity.BookInfo;
import com.libsys.entity.Page;

public interface IBookInfoService {

	//添加图书方法
	public int add(BookInfo bf);

	//查询所有图书
	public List findAll();

	//删除图书
	public int deleteBook(BookInfo bt);

	//修改图书
	public int update(BookInfo bt);

	//通过书名查书
	public List findByBname(BookInfo bt);
	
	//通过书名查书之查记录数量
	public BookAndPage findByBnameCount(BookAndPage bp);
	

	//通过作者查找
	public List findByAuthor(BookInfo bt);

	//获取分页显示的页数
	public Page showPages(Page p);

	//通过页数显示图书
	public List findByPage(Page p);

	//通过书名查书，实现分页
	public List findByBnameImpl(BookAndPage bp);

	//通过作者查找记录数量
	public BookAndPage findByAuthorCount(BookAndPage bp);

	//通过作者，实现分页
	public List findByAuthorImpl(BookAndPage bp);

	

	
	
	

}
