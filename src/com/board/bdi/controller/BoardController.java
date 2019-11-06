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

import com.board.bdi.service.BoardService;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/board/list";
		String url = "";
		int result;
		Map<String, String> board = new HashMap<>();
		String msg = "";
		if ("list".equals(cmd)) {
			request.setAttribute("list", bs.getBoardList());

		} else if ("delete".equals(cmd)) {
			board.put("biNum", request.getParameter("biNum"));
			result = bs.deleteBoard(board);
			path = "/views/msg";
			if (result != 1) {
				url = "/board/list";
				msg = "삭제 실패";
			} else {
				url = "/board/list";
				msg = "삭제 완료";
			}
		} else if ("update".equals(cmd)) {
			path = "/views/board/update";
			board.put("biNum", request.getParameter("biNum"));
			board = bs.selectBoard(board);
			request.setAttribute("board", board);

		} else if ("view".equals(cmd)) {
			path = "/views/board/view";
			board.put("biNum", request.getParameter("biNum"));
			board = bs.selectBoard(board);
			request.setAttribute("board", board);
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/board/list";
		String url = "/board/list";
		String msg = "게시물이 저장되었습니다.";
		HttpSession hs = request.getSession();
		Map<String, String> board = new HashMap<>();
		int result;
		if ("insert".equals(cmd)) {
			board.put("bi_title", request.getParameter("bi_title"));
			board.put("bi_content", request.getParameter("bi_content"));
			Map<String, Object> user = (Map<String, Object>) hs.getAttribute("user");
			board.put("ui_num", user.get("uiNum").toString());
			result = bs.insertBoard(board);
			path = "/views/msg";
			if (result != 1) {
				path = "/views/board/insert";
				msg = "저장 실패";
			}
		} else if ("update".equals(cmd)) {
			board.put("biTitle", request.getParameter("biTitle"));
			board.put("biContent", request.getParameter("biContent"));
			board.put("biNum", request.getParameter("biNum"));
			result = bs.updateBoard(board);
			path = "/views/msg";
			if (result != 1) {
				url = "/board/list";
				msg = "수정 실패";
			} else {
				url = "/board/list";
				msg = "수정 완료";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
