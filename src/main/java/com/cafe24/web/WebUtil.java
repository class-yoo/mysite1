package com.cafe24.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {

	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url)
			throws IOException, ServletException { 
		// url을 재요청 - 리다이렉트(나의 응답은 너의 주소를 옮기는 것이야 라고 응답함)
		response.sendRedirect(url);
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String location) // 위치이동
			throws ServletException, IOException {
		// 외부에서는 못하지만 내부에서 경로이동가능 - 포워딩 (request가 연장됨.)
		RequestDispatcher rd = request.getRequestDispatcher(location);
		rd.forward(request, response);
	}

}
