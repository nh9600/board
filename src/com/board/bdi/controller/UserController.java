package com.board.bdi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.bdi.service.UserService;
import com.board.bdi.service.impl.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl() {
	};
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/user/list";
		Map<String,String> user = new HashMap<String,String>();
		if("list".equals(cmd)) {
			if(request.getParameter("uiId")!=null && !request.getParameter("uiId").trim().equals("")){
				user.put("uiID",request.getParameter("uiId"));
			}
			if(request.getParameter("uiNum")!=null && !request.getParameter("uiNum").trim().equals("")){
				user.put("uiNum",request.getParameter("uiNum"));
			}
			if(request.getParameter("uiName")!=null && !request.getParameter("uiName").trim().equals("")){
				user.put("uiName",request.getParameter("uiName"));
			}
			request.setAttribute("list", us.getUserList(user));
		}else if("logout".equals(cmd)) {
			HttpSession hs = request.getSession();
			hs.invalidate();
			path = "/";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uiId=request.getParameter("uiId");
		String uiPwd=request.getParameter("uiPwd");
		String uiName=request.getParameter("uiName");
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path="/views/msg";//바로 msg로 가는게 아니라 URI컨트롤러를 타고 감
		if("login".equals(cmd)) {
			Map<String,String> user = us.doLogin(uiId, uiPwd);
		if(user!=null) {
			HttpSession hs = request.getSession();
			hs.setAttribute("user", user);
			request.setAttribute("msg","로그인 성공");
			request.setAttribute("url","/views/index");//views니까 uri컨트롤러를 타고 WEB-INF/views/index.jsp(물리적 위치로 감)
		}else {
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("url","/views/login");
		}
		}else if("signup".equals(cmd)){
			Map<String,Object> userinfo = us.doSignup(uiName,uiId, uiPwd);
			if(userinfo!=null) {
			HttpSession hs = request.getSession();
			request.setAttribute("msg","가입 성공");
			request.setAttribute("url","/views/index");//views니까 uri컨트롤러를 타고 WEB-INF/views/index.jsp(물리적 위치로 감)
		}else {
				request.setAttribute("msg", "가입 실패");
				request.setAttribute("url","/views/signup");
		}
		}else if("logout".equals(cmd)){
		
		}else if("update".equals(cmd)){
		
		}else if("delete".equals(cmd)){
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
		//doGet(request, response);
	}

}
