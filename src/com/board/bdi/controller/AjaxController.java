package com.board.bdi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/thml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("이름:"+name);
		out.println("나이:"+age);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[]args) {
		String jsonStr = "{\"name\":\"우리나라\"}";
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(jsonStr,Map.class);
		System.out.println(map);
	}

}
