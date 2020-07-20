package com.libsys.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.libsys.dao.ITypeInfoDao;

import com.libsys.entity.TypeInfo;
import com.libsys.service.ITypeInfoService;

//使用@Service注解在Spring容器中注册名为typeInfoService的typeInfoServiceImpl实例
@Service("typeInfoService")
//使用@Transactional注解实现事务管理
@Transactional
public class TypeInfoServiceImpl implements ITypeInfoService{
	//使用@Autowired注解注入typeInfoDAOImpl实例
	@Autowired
	ITypeInfoDao typeInfoDao;

	//查询添加的类型是否重复
	@Override
	public List<TypeInfo> checkType(TypeInfo tf) {
		// TODO Auto-generated method stub
		return typeInfoDao.checkName(tf);
	}

	//添加图书类型
	@Override
	public List<TypeInfo> addType(TypeInfo tf) {
		// TODO Auto-generated method stub
		return typeInfoDao.addType(tf);
	}

	//查找所有图书类型
	@Override
	public List<TypeInfo> findAll() {
		// TODO Auto-generated method stub
		return typeInfoDao.findAll();
	}

	//修改图书类型
	@Override
	public int update(TypeInfo tf) {
		// TODO Auto-generated method stub
		return typeInfoDao.update(tf);
	}

	@Override
	public int deleteType(TypeInfo tf) {
		// TODO Auto-generated method stub
		return typeInfoDao.deleteType(tf);
	}


}
