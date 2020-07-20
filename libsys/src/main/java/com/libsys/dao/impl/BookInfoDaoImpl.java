package com.libsys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libsys.dao.IBookInfoDao;
import com.libsys.entity.BookAndPage;
import com.libsys.entity.BookAndType;
import com.libsys.entity.BookInfo;
import com.libsys.entity.Page;

//使用@Repository注解在Spring容器中注册实例名为IBookInfoDao的IBookInfoDaoImpl实例
@Repository("IBookInfoDao")
public class BookInfoDaoImpl implements IBookInfoDao{
	// 通过@Autowired注解注入Spring容器中的SessionFactory实例
		@Autowired
		SessionFactory sessionFactory;

		//添加图书
		@Override
		public int add(BookInfo bf) {
			//获取session
			Session session = sessionFactory.getCurrentSession();
			
			int res = (int)session.save(bf);
			return res;
			
		}

		//查找所有图书
		//此处联合查询，建立了一个联合结果的类
		//新的解决方式 ：直接查询bookInfo，类型的事情交给前提
		@Override
		public List findAll() {
			//获取session
			Session session = sessionFactory.getCurrentSession();
			//String str = "select new com.libsys.entity.BookAndType(b.bid,b.bname,t.tname,b.author,b.price) from BookInfo as b,TypeInfo as t where b.tid = t.tno order by b.bid";
			String str ="from BookInfo";
			Query q = session.createQuery(str);
			List list = q.list();
			return list;
		}
		
		//删除图书
		@Override
		public int deleteBook(BookInfo bt) {
			Session session = sessionFactory.getCurrentSession();
			String str = "delete BookInfo where bid = :bid";
			int res = session.createQuery(str).setInteger("bid", bt.getBid()).executeUpdate();
			return res;
		}

		//修改图书
		//想法：2个sql语句进行修改，分别对2张表进行修改？？？
		//解决办法：底层图书类型还是图书类型的id，在前端的select标签中奖图书类型的标签值转换成相应的图书类型
		@Override
		public int update(BookInfo bt) {
			Session session = sessionFactory.getCurrentSession();
			session.update(bt);
			return 1;
		}

		//通过书名查书
		@Override
		public List findByBname(BookInfo bt) {
			Session session = sessionFactory.getCurrentSession();
			String str = "from BookInfo where bname like :bname";
			List list = session.createQuery(str).setString("bname", "%"+bt.getBname()+"%").list();
			return list;
		}

		//通过作者查书
		@Override
		public List findByAuthor(BookInfo bt) {
			Session session = sessionFactory.getCurrentSession();
			String str = "from BookInfo as bf where bf.author like :author";
			List list = session.createQuery(str).setString("author", "%"+bt.getAuthor()+"%").list();
			return list;
		}

		//获取分页显示的页数
		@Override
		public Page showPages(Page p) {
			/**
		     *  其中currentPage,perPageRows这两个参数是做分页查询必须具备的参数
		     *  原因是：hibernate中的Criteria或则是Query这两个接口：都有setFirstResult(Integer firstResult)
		     *  和setMaxResult(Integer maxResult),
		     *  这里的firstResult就是每页的开始的索引数：
		     *  每页开始的索引数的计算公式是：（currentPage-1）*perPageRows+1,(这是相对索引从1开始的)
		     *  但是Hibernate中的firstResult的索引是从0开始的，所以在hibernate中每页开始的索引数的计算公式是：
		     *  (currentPage-1)*perPageRows+1-1=(currentPge-1)*perPageRows.
		     *
		     *  maxResult就是每页能查询的最大记录数：也就是perPageRows.
		     *
		     *  Math.ceil(totalRows/perPageRows)==totalPages;//这是根据总记录数和每页的记录数算出总页数的计算公式。
		     */
			Session session = sessionFactory.getCurrentSession();
			//获取表中的总记录
			String hql = "select count(*) from BookInfo";
			Query q = session.createQuery(hql);
			List list = q.list();
			int count = Integer.parseInt(list.get(0) + "");//记录总数
			System.out.println("记录总数count:"+count);
			//将计算的总记录保存并返回
			p.setTotalRows(count);
			return p;
		}

		//通过页数返回图书
		@Override
		public List findByPage(Page p) {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from BookInfo";
			//计算出页面对应的第一个记录的下标
			int beg = (p.getCurrentPage()-1)*p.getPerPageRows();
			List list = session.createQuery(hql).setFirstResult(beg).setMaxResults(p.getPerPageRows()).list();
			return list;
		}

		//通过书名查书，返回找到书的数量
		@Override
		public BookAndPage findByBnameCount(BookAndPage bp) {
			Session session = sessionFactory.getCurrentSession();
//			System.out.println("DAO层中初始BookAndPage"+bp);
//			System.out.println("Bname:"+bp.getBname());
			//获取表中的总记录
			String hql = "select count(*) from BookInfo where bname like:bname";
			List list = session.createQuery(hql).setString("bname","%"+bp.getBname()+"%").list();
			int count = Integer.parseInt(list.get(0) + "");//记录总数
			bp.setTotalRows(count);
			return bp;
		}

		//通过书名查书，实现分页
		@Override
		public List findByBnameImpl(BookAndPage bp) {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from BookInfo where bname like:bname";
			//计算出开始的下标
			int begin = (bp.getCurrentPage()-1)*bp.getPerPageRows();
			System.out.println("begain:"+begin);
			List list = session.createQuery(hql).setString("bname", "%"+bp.getBname()+"%").setFirstResult(begin).setMaxResults(bp.getPerPageRows()).list();
			
			return list;
		}

		//通过作者查书，返回找到书的数量
		@Override
		public BookAndPage findByAuthorCount(BookAndPage bp) {
			Session session = sessionFactory.getCurrentSession();
//			System.out.println("DAO层中初始BookAndPage"+bp);
//			System.out.println("Bname:"+bp.getBname());
			//获取表中的总记录
			String hql = "select count(*) from BookInfo where author like:author";
			List list = session.createQuery(hql).setString("author","%"+bp.getAuthor()+"%").list();
			int count = Integer.parseInt(list.get(0) + "");//记录总数
			bp.setTotalRows(count);
			return bp;
		}

		//通过作者查书，实现分页
		@Override
		public List findByAuthorImpl(BookAndPage bp) {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from BookInfo where author like:author";
			//计算出开始的下标
			int begin = (bp.getCurrentPage()-1)*bp.getPerPageRows();
			System.out.println("begain:"+begin);
			List list = session.createQuery(hql).setString("author","%"+bp.getAuthor()+"%").setFirstResult(begin).setMaxResults(bp.getPerPageRows()).list();
			
			return list;
		}
		
		
		
}
