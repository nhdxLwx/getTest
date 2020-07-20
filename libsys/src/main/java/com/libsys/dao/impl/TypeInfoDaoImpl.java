package com.libsys.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libsys.dao.ITypeInfoDao;
import com.libsys.entity.AdminInfo;
import com.libsys.entity.TypeInfo;

//使用@Repository注解在Spring容器中注册实例名为IAdminInfoDAO的AdminInfoDAOImpl实例
@Repository("ITypeInfoDAO")
public class TypeInfoDaoImpl implements ITypeInfoDao{
	// 通过@Autowired注解注入Spring容器中的SessionFactory实例
	@Autowired
	SessionFactory sessionFactory;

	//查询添加的类型是否重复
	@Override
	public List<TypeInfo> checkName(TypeInfo tf) {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TypeInfo  where tname=:tname";	//hql语句
		Query q = session.createQuery(hql);
		//获取参数
		q.setString("tname", tf.getTname());
		List<TypeInfo> list = q.list();
		return list;
	}

	//添加图书类型
	@Override
	public List<TypeInfo> addType(TypeInfo tf) {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		session.save(tf);
		return null;
	}

	//找出所有图书类型
	@Override
	public List<TypeInfo> findAll() {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		String hql = "from TypeInfo";	//hql语句
		Query q = session.createQuery(hql);
		List<TypeInfo> list = q.list();
		return list;
	}

	//修改图书类型
	@Override
	public int update(TypeInfo tf) {
		// 获得session
		Session session = sessionFactory.getCurrentSession();
		String hql = "update TypeInfo set tname=:tname where tno = :tno";
		//尝试将多条语句缩成一条语句
		int result =session.createQuery(hql).setInteger("tno", tf.getTno()).setString("tname", tf.getTname()).executeUpdate();
		
		return result;
	}

	//删除图书类型
	@Override
	public int deleteType(TypeInfo tf) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete TypeInfo where tno = :tno";
		int result =session.createQuery(hql).setInteger("tno", tf.getTno()).executeUpdate();
		System.out.println("删除："+result);
		return result;
	}
}
