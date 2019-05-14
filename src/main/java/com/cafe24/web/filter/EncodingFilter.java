package com.cafe24.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Encoding Filter initialized");
		encoding =fConfig.getInitParameter("encoding"); //web.xml에 설정한 Encoding 값을 가져온다.
		if(encoding ==null) {
			
			encoding = "utf-8";
		}
			
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		request 처리
		request.setCharacterEncoding(encoding); // web.xml에 encoding이란 이름으로 매핑한 문자열형태의 인코딩 형식을 저장한다.
		
		chain.doFilter(request, response);
		
		
//		response 처리
		
	}

	
	
	
	public void destroy() {
	}
	

}
