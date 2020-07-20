package com.libsys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libsys.entity.AdminInfo;
import com.libsys.service.IAdminInfoService;


@Controller
@RequestMapping("/admin")
public class AdiminInfoControl extends BasicController{

	private static final long serialVersionUID = -1564287438917352900L;
	// 使用@Autowired注解注入服务层实例
	@Autowired
	private IAdminInfoService adminInfoService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public AdminInfo login(HttpSession session,AdminInfo af) {

		List<AdminInfo> adminInfo=adminInfoService.login(af);
//		System.out.println("控制层的login的信息"+adminInfo);
		if (adminInfo.size() > 0) {
			// 登录成功,设置当前登录信息
			//			System.out.println("登录成功");
//			System.out.println("控制层的login的第一个值"+adminInfo.get(0));
			session.setAttribute("currentLoginAdmin", adminInfo.get(0));
			
			return adminInfo.get(0);
		} else {
			// 登录失败，重定向到login.jsp
			return null;
		}
	}

	@RequestMapping(value="/checkName", method=RequestMethod.POST)
	@ResponseBody
	public AdminInfo checkName(HttpSession session,AdminInfo af) {

		List<AdminInfo> adminInfo= adminInfoService.checkName(af);
		if(adminInfo.size()==0){
			return null;
		}else{
			return adminInfo.get(0);
		}
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public int register(HttpSession session,AdminInfo af) {

		List<AdminInfo> adminInfo=adminInfoService.register(af);
		System.out.println(adminInfo);
		if (adminInfo ==null ) {
			return 1;
		} else {
			return 0;
		}
	}

	//注销
	@RequestMapping("/loginout")

	public String loginout(HttpSession session) {
		session.removeAttribute("currentLoginAdmin");
		session.invalidate();
		return "redirect:../login.html";
	}


}

