package com.libsys.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.libsys.dao.IAdminInfoDao;
import com.libsys.entity.AdminInfo;
import com.libsys.util.MD5Encryption;

//使用@Repository注解在Spring容器中注册实例名为IAdminInfoDAO的AdminInfoDAOImpl实例
@Repository("IAdminInfoDAO")
public class AdminInfoDaoImpl implements IAdminInfoDao{

	// 通过@Autowired注解注入Spring容器中的SessionFactory实例
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<AdminInfo> search(AdminInfo cond) {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		String hql = "from AdminInfo  where aname=:aname and pwd=password(:pwd)";	//hql语句
		Query q = session.createQuery(hql);
		//获取参数
		q.setString("aname", cond.getAname());
		q.setString("pwd", cond.getPwd());
		List<AdminInfo> list = q.list();
		return list;
	}

	//注册时查询注册的名字是否重复
	@Override
	public List<AdminInfo> checkName(AdminInfo af) {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		String hql = "from AdminInfo  where aname=:aname";	//hql语句
		Query q = session.createQuery(hql);
		//获取参数
		q.setString("aname", af.getAname());
		List<AdminInfo> list = q.list();
		return list;
	}

	@Override
	public List<AdminInfo> register(AdminInfo af) {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		//没想到好的办法，先保存，然后修改密码,将其改成password格式
		session.save(af);
		String hql = "update AdminInfo set pwd=password(:pwd) where aname = :aname";
		Query q = session.createQuery(hql);
		//获取参数
		q.setString("pwd", af.getPwd());
		q.setString("aname", af.getAname());
		int result =q.executeUpdate();
		return null;
	}

}
