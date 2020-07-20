package com.libsys.service.impl;

import java.util.List;

import javax.persistence.criteria.Predicate.BooleanOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libsys.dao.IBookInfoDao;
import com.libsys.entity.BookAndPage;
import com.libsys.entity.BookAndType;
import com.libsys.entity.BookInfo;
import com.libsys.entity.Page;
import com.libsys.service.IBookInfoService;

@Service("IBookInfoService")
//使用@Transactional注解实现事务管理
@Transactional
public class BookInfoServiceImpl implements IBookInfoService {
	
	@Autowired
	private IBookInfoDao bookInfoDao;

	//添加图书
	@Override
	public int add(BookInfo bf) {
		return bookInfoDao.add(bf);
	}
	
	//查找所有图书
	@Override
	public List findAll() {
		
		return bookInfoDao.findAll();
	}

	//删除图书
	@Override
	public int deleteBook(BookInfo bt) {
		// TODO Auto-generated method stub
		return bookInfoDao.deleteBook(bt);
	}

	//修改图书
	@Override
	public int update(BookInfo bt) {
		// TODO Auto-generated method stub
		return bookInfoDao.update(bt);
	}

	//通过书名查书
	@Override
	public List findByBname(BookInfo bt) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByBname(bt);
	}

	@Override
	public List findByAuthor(BookInfo bt) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByAuthor(bt);
	}

	@Override
	public Page showPages(Page p) {
		// TODO Auto-generated method stub
		return bookInfoDao.showPages(p);
	}

	@Override
	public List findByPage(Page p) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByPage(p);
	}


	//通过书名查书，查有多少满足的记录
	@Override
	public BookAndPage findByBnameCount(BookAndPage bp) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByBnameCount(bp);
	}

	//通过书名查书实现分页
	@Override
	public List findByBnameImpl(BookAndPage bp) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByBnameImpl(bp);
	}

	@Override
	public BookAndPage findByAuthorCount(BookAndPage bp) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByAuthorCount(bp);
	}

	@Override
	public List findByAuthorImpl(BookAndPage bp) {
		// TODO Auto-generated method stub
		return bookInfoDao.findByAuthorImpl(bp);
	}
	
}
