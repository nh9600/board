package com.board.bdi.test.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.board.bdi.test.BoardDAO;

public class BoardDAOImpl implements BoardDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public int insertBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "insert into board_info(bi_num,bi_title,bi_content,ui_num,credat,cretim,moddat,modtim)";
			sql += "values(seq_bi_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, "biTitle");
			ps.setString(2, "biContent");
			ps.setString(3, "uiNum");
			return ps.executeUpdate();// 리턴 시켜줌, 집어 넣은 값이 에러일때는 여기서 오류남
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAOImpl();
		Map<String,String> board = new HashMap<>();
		board.put("biTitle","test title");
		board.put("biContent","test content");
		board.put("biNum","test num");
		int result = bdao.insertBoard(board);// 맵만 들어갈 수 있음,null이니까 저장안됨 뜸
		if (result == 1) {
			System.out.println("저장잘됨");
		} else {
			System.out.println("저장안됨");
		}
	}

}
