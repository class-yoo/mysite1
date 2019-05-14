package com.cafe24.mysite.action.user;

import com.cafe24.mysite.action.main.MainAction;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		// a="joinform"이 들어오면 화면을나타내고 a="join"이 들어오면 insert한후에 redirect하여 다음 화면을 나타냄 
		
		if("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if("join".equals(actionName)) {
			action = new JoinAction();
		}else if("joinsuccess".equals(actionName)) {
			action = new JoinAction();
		}else {
			action = new MainAction();
		}
		
		return action;
	}

}