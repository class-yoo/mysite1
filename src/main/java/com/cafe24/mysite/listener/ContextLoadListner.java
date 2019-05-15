package com.cafe24.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class ContextLoadListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		System.out.println("Container Starts....."
				+ servletContextEvent.getServletContext().getInitParameter("contextConfigLocation"));
		// Context는 Spring과 Tomcat이 중요하게 여기는 시선이 다르기 때문에 Context의 의미가 상이하다.
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
}
