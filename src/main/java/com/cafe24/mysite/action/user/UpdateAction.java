package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		UserVo userVo = new UserVo();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		HttpSession session = request.getSession(true);
		UserVo authUser = (UserVo)session.getAttribute("authUser"); // session에서 가르키고 있는 객체의 주소값을 그대로 가져옴
		
		userVo.setNo(authUser.getNo());
		userVo.setName(name);
		userVo.setPassword(password);
		userVo.setGender(gender);
		
		if(new UserDao().updateUser(userVo)) {
			
			authUser.setName(name); // 그래서 객체를 다시 setAttribute 해서 넣어줄  필요없이 바로 저장해주면 된다. 
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		WebUtil.redirect(request, response, request.getContextPath());
		
	}

}
