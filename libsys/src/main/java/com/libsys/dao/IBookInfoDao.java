package com.libsys.dao;

import java.util.List;

import com.libsys.entity.BookAndPage;
import com.libsys.entity.BookAndType;
import com.libsys.entity.BookInfo;
import com.libsys.entity.Page;

public interface IBookInfoDao {

	public int add(BookInfo bf);

	public List findAll();

	public int deleteBook(BookInfo bt);

	public int update(BookInfo bt);

	public List findByBname(BookInfo bt);

	public List findByAuthor(BookInfo bt);

	public Page showPages(Page p);

	public List findByPage(Page p);

	public BookAndPage findByBnameCount(BookAndPage bp);

	public List findByBnameImpl(BookAndPage bp);

	public BookAndPage findByAuthorCount(BookAndPage bp);

	public List findByAuthorImpl(BookAndPage bp);


}
