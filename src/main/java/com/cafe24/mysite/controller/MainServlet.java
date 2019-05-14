package com.cafe24.mysite.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.action.guestbook.GuestBookActionFactory;
import com.cafe24.mysite.action.main.MainActionFactory;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // 필터로 등록해두면 신경안써도됨
		
		String actionName = request.getParameter("a");
		// 팩토리 메소드를 사용하여 구현함 actionName을 받아서 인자값으로 넣어줌으로써 각 상황에 맞게 생성되는 Action에 맞게 실행된다.
		// execute 메소드를 구현하고 있는 ~~~~Action 클래스들이 자신의 기능에 맞게 실행한다.
		Action action = new MainActionFactory().getAction(actionName);
		action.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
