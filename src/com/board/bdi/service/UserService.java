package com.board.bdi.service;

import java.util.List;
import java.util.Map;

public interface UserService {	
	
	public Map<String,String> doLogin(String id,String pwd);
	public Map<String,Object> doSignup(String name, String id,String pwd);
	public List<Map<String,String>> getUserList(Map<String,String> user);

}
