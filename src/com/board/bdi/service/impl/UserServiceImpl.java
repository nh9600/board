package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	
	public Map<String,String> doLogin(String uiId, String uiPwd) {
		Map<String,String> user = new HashMap<>();
		user.put("uiId",uiId);
		user.put("uiPwd",uiPwd);
		return udao.selectUser(user);//userdao로 넘어감 
	}
	
	public Map<String, Object> doSignup(String uiName, String uiId, String uiPwd){
		Map<String,Object> userinfo = new HashMap<>();
		userinfo.put("uiName",uiName);
		userinfo.put("uiId",uiId);
		userinfo.put("uiPwd",uiPwd);
		return udao.signupinfo(userinfo);
		
	}
	
	//public Map<String,Object> doSignup(String uiName,String uiId,String uiPwd){
		//Map<String,Object> 
	//}

}
