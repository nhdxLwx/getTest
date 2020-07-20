package com.libsys.dao;

import java.util.List;

import com.libsys.entity.AdminInfo;

public interface IAdminInfoDao {

	public List<AdminInfo> search(AdminInfo cond);

	public List<AdminInfo> checkName(AdminInfo af);

	public List<AdminInfo> register(AdminInfo af);
	
}
