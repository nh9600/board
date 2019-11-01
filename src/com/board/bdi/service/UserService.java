package com.board.bdi.service;

import java.util.Map;

public interface UserService {	
	
	public Map<String,String> doLogin(String id,String pwd);
	public Map<String,Object> doSignup(String name, String id,String pwd);

}
