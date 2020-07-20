package com.libsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libsys.dao.IAdminInfoDao;
import com.libsys.entity.AdminInfo;
import com.libsys.service.IAdminInfoService;


//使用@Service注解在Spring容器中注册名为adminInfoService的adminInfoServiceImpl实例
@Service("adminInfoService")
//使用@Transactional注解实现事务管理
@Transactional
public class AdminInfoServiceImpl  implements IAdminInfoService{

	//使用@Autowired注解注入adminInDAOImpl实例
	@Autowired
	IAdminInfoDao adminInfoDao;

	//登录
	@Override
	public List<AdminInfo> login(AdminInfo cond) {
		// TODO Auto-generated method stub
		return adminInfoDao.search(cond);
	}

	//注册时查询注册的名字是否重复
	@Override
	public List<AdminInfo> checkName(AdminInfo af) {
		// TODO Auto-generated method stub
		return adminInfoDao.checkName(af);
	}

	//注册
	@Override
	public List<AdminInfo> register(AdminInfo af) {
		// TODO Auto-generated method stub
		return adminInfoDao.register(af);
	}    



}
