package com.libsys.service;

import java.util.List;

import com.libsys.entity.AdminInfo;

public interface IAdminInfoService {
	//登录
	public List<AdminInfo> login(AdminInfo cond);
	
	//注册时查询注册的名字是否重复
	public List<AdminInfo> checkName(AdminInfo af);

	public List<AdminInfo> register(AdminInfo af);
	
}
