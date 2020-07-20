package com.libsys.service;

import java.util.List;


import com.libsys.entity.TypeInfo;

public interface ITypeInfoService {
	//查重
	public List<TypeInfo> checkType(TypeInfo tf);

	//添加图书类型
	public List<TypeInfo> addType(TypeInfo tf);

	//查找所有图书类型
	public List<TypeInfo> findAll();

	//修改图书类型
	public int update(TypeInfo tf);

	//删除图书类型
	public int deleteType(TypeInfo tf);
}
