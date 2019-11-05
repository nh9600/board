package com.board.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/views/test/jstl";
		List<Map<String,String>> list = new ArrayList<>();
		for(int i=1;i<=10;i++) {
			Map<String,String> tt = new HashMap<>();//맵 10개
			tt.put("name","이름"+i);
			tt.put("age",""+i);
			list.add(tt);//리스트에 담기
		}
		request.setAttribute("list",list);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
