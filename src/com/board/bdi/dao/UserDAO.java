package com.board.bdi.dao;

import java.util.Map;

public interface UserDAO {
	public Map<String,String> selectUser(Map<String,String> user);
	public Map<String,Object> signupinfo(Map<String,Object> userinfo);
}
