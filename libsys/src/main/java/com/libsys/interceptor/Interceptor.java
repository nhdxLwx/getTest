package com.libsys.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("/admin/login")>=0){
			System.out.println("用户登录不拦截ing");
			return true;
		}
		if(request.getSession().getAttribute("currentLoginAdmin") != null){
			System.out.println(request.getSession().getAttribute("currentLoginAdmin"));
			System.out.println("用户已经登录不拦截！！！！");
			return true;
		}
		else{
			System.out.println("非用户登录拦截ing");
			response.setContentType("text/html;chartset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请先登录...');location.href='../login.html'</script>");
			// .flush()将缓冲区的数据强制输出，用于清空缓冲区，若直接调用close()方法，则可能会丢失缓冲区的数据。所以通俗来讲它起到的是刷新的作用。
			out.flush();
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器生效ing");
	}

}