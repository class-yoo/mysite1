package com.cafe24.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class MainAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 메인에 왔을때 클라이언트의 쿠키정보를 남긴다.
		
		/* Cookie Test */
		int count = 0;

		// 쿠키읽기
		// JSession 아이디를 직접만들지는 않는다.
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if ("visitCount".equals(c.getName())) {
					count = Integer.parseInt(c.getValue());
				}
			}
		}

		// 쿠키쓰기
		count++;
		Cookie cookie = new Cookie("visitCount", String.valueOf(count));
		cookie.setMaxAge(24 * 60 * 60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);

		WebUtil.forward(request, response, "/WEB-INF/views/main/index.jsp");

	}

}
