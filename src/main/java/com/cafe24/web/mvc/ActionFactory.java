package com.cafe24.web.mvc;

public abstract class ActionFactory {
	
	
	public abstract Action getAction(String actionName); //하부에서 자신이 원하는대로 만들어내는 패턴
}
