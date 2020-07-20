package com.libsys.dao;

import java.util.List;


import com.libsys.entity.TypeInfo;

public interface ITypeInfoDao {

	public List<TypeInfo> checkName(TypeInfo af);

	public List<TypeInfo> addType(TypeInfo tf);

	public List<TypeInfo> findAll();

	public int update(TypeInfo tf);

	public int deleteType(TypeInfo tf);



}
