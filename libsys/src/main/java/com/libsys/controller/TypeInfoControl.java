package com.libsys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libsys.entity.TypeInfo;
import com.libsys.service.ITypeInfoService;


@Controller
@RequestMapping("/type")
public class TypeInfoControl {
	// 使用@Autowired注解注入服务层实例
	@Autowired
	private ITypeInfoService typeInfoService;

	//检查类型是否重复
	@RequestMapping(value="/checkType", method=RequestMethod.POST)
	@ResponseBody
	public TypeInfo checkType(HttpSession session, TypeInfo tf) {

		List<TypeInfo> typeInfo=typeInfoService.checkType(tf);
		if(typeInfo.size()==0){
			return null;
		}else{
			return typeInfo.get(0);
		}

	}
	//添加图书类型
	@RequestMapping(value="/addType", method=RequestMethod.POST)
	@ResponseBody
	public int addType(HttpSession session, TypeInfo tf) {

		List<TypeInfo> typeInfo=typeInfoService.addType(tf);
		if (typeInfo ==null ) {
			return 1;
		} else {
			return 0;
		}

	}

	//查找出所有的图书类型
	@RequestMapping(value="/findAll", method=RequestMethod.POST)
	@ResponseBody
	public List<TypeInfo> findAll(HttpSession session) {

		List<TypeInfo> typeInfo =typeInfoService.findAll();
		//System.out.println("查找的结果:"+typeInfo);
		return typeInfo;
	}

	//修改图书类型
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public int update(HttpSession session,TypeInfo tf) {
		//直接交给服务层即可
		return typeInfoService.update(tf);
	}

	//删除图书类型
	@RequestMapping(value="/deleteType", method=RequestMethod.POST)
	@ResponseBody
	public int deleteType(HttpSession session,TypeInfo tf) {
		//直接交给服务层即可
		return typeInfoService.deleteType(tf);
	}
}
