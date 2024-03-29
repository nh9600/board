package com.board.bdi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.bdi.service.BoardService;
import com.google.gson.Gson;

public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Map<String,String>>hList =  bs.getBoardList();
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		pw.print(gson.toJson(hList));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[]args) {
		Map<String,String> map = new HashMap<>();
		map.put("name","홍길동");
		map.put("age","33");
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		System.out.println(jsonStr);
	}

}
