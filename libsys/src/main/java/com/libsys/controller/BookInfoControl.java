package com.libsys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libsys.entity.BookAndPage;
import com.libsys.entity.BookInfo;
import com.libsys.entity.Page;
import com.libsys.service.IBookInfoService;

@Controller
@RequestMapping("/book")
public class BookInfoControl {

	@Autowired
	private IBookInfoService bookInfoService;

	//添加图书
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public int register(HttpSession session,BookInfo bf) {

		int result=bookInfoService.add(bf);
		System.out.println(result);
		return result;
	}

	//查询所有图书
	/**
	 * 这里用到多表查询，返回值为list，到时候需要转换，在dao层已经用联合查询的结果的类完成转换
	 * 
	 * 
	 * 
	 */
	@RequestMapping(value="/findAll", method=RequestMethod.POST)
	@ResponseBody
	public List findAll(HttpSession session) {

		List result=bookInfoService.findAll();

		return result;
	}

	//修改
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public int update(HttpSession session,BookInfo bt) {

		int result=bookInfoService.update(bt);
		System.out.println("控制层修改的结果:"+result);
		return result;
	}

	//删除
	@RequestMapping(value="/deleteBook", method=RequestMethod.POST)
	@ResponseBody
	public int deleteBook(HttpSession session,BookInfo bt) {

		int result=bookInfoService.deleteBook(bt);
		return result;
	}

	//通过名字查找书,未实现分页
	@RequestMapping(value="/findByBname", method=RequestMethod.POST)
	@ResponseBody
	public List findByBname(HttpSession session,BookInfo bt) {

		List result=bookInfoService.findByBname(bt);
		System.out.println("控制层list的大小"+result.size());
		return result;
	}

	//通过名字查找书,主要查出符合条件有多少记录
	@RequestMapping(value="/findByBnameCount", method=RequestMethod.POST)
	@ResponseBody
	public BookAndPage findByBnameCount(HttpSession session,BookAndPage bp) {

		System.out.println("控制层的bname:"+bp.getBname());
		BookAndPage result=bookInfoService.findByBnameCount(bp);
		return result;
	}

	//实现分页
	@RequestMapping(value="/findByBnameImpl", method=RequestMethod.POST)
	@ResponseBody
	public List findByBnameImpl(HttpSession session,BookAndPage bp) {

		List result=bookInfoService.findByBnameImpl(bp);
		return result;
	}

	//通过作者查找书
	@RequestMapping(value="/findByAuthor", method=RequestMethod.POST)
	@ResponseBody
	public List findByAuthor(HttpSession session,BookInfo bt) {

		List result=bookInfoService.findByAuthor(bt);
		return result;
	}

	//通过作者查找书,主要查出符合条件有多少记录
	@RequestMapping(value="/findByAuthorCount", method=RequestMethod.POST)
	@ResponseBody
	public BookAndPage findByAuthorCount(HttpSession session,BookAndPage bp) {

		
		BookAndPage result=bookInfoService.findByAuthorCount(bp);
		return result;
	}

	//实现分页
	@RequestMapping(value="/findByAuthorImpl", method=RequestMethod.POST)
	@ResponseBody
	public List findByAuthorImpl(HttpSession session,BookAndPage bp) {

		List result=bookInfoService.findByAuthorImpl(bp);
		return result;
	}


	//显示页面目录showPages
	@RequestMapping(value="/showPages", method=RequestMethod.POST)
	@ResponseBody
	public Page showPages(HttpSession session,Page p) {

		Page result=bookInfoService.showPages(p);
		return result;
	}

	//按页面显示
	@RequestMapping(value="/findByPage", method=RequestMethod.POST)
	@ResponseBody
	public List findByPage(HttpSession session,Page p) {

		List result=bookInfoService.findByPage(p);

		return result;
	}

}
