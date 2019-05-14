package com.cafe24.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.web.WebUtil;

public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionName = request.getParameter("a");
		if ("add".equals(actionName)) {
			
		} else if ("deleteform".equals(actionName)) {

		} else if ("delete".equals(actionName)) {

		} else {
//			list action
			
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.getList();
			
			request.setAttribute("list", list);
			
			WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
