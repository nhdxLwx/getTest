package com.libsys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  BasicController extends HttpServlet{
	private static final long  serialVersionUID = -3808609982371106118L;
	@Override
	protected void  doGet(HttpServletRequest req, HttpServletResponse resp)  throws  ServletException, IOException {
		doPost(req, resp);
	}

	protected void  send(HttpServletResponse response, int result)  throws  IOException {
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}

	protected void  send(HttpServletResponse response, String str)  throws  IOException {
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
	}

	protected void  send(HttpServletResponse response, Object obj)  throws  IOException {
		PrintWriter out = response.getWriter();
		out.print(obj);
		out.flush();
	}
}

