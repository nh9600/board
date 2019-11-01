package com.board.bdi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF";
	private static final String SUFFIX = ".jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
	    uri=PREFIX+ uri +SUFFIX;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);//doGet메서드를 호출 위에 것을 읽음
	}

}
