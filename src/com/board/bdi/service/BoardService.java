package com.board.bdi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public List<Map<String, String>> getBoardList() {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from board_info bi , user_info ui where bi.ui_num=ui.ui_num order by bi.bi_num desc ";
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String, String>> boardList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> bi = new HashMap<>();
				bi.put("biNum", rs.getString("bi_num"));
				bi.put("biTitle", rs.getString("bi_title"));
				bi.put("biContent", rs.getString("bi_content"));
				bi.put("uiNum", rs.getString("ui_num"));
				bi.put("uiName", rs.getString("ui_name"));
				bi.put("credat", rs.getString("credat"));
				bi.put("cretim", rs.getString("cretim"));
				bi.put("moddat", rs.getString("moddat"));
				bi.put("modtim", rs.getString("modtim"));
				bi.put("active", rs.getString("active"));
				boardList.add(bi);// 리스트에 집어넣음
			}
			return boardList;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BoardService ib = new BoardService();
		ib.insertBoard(null);
	}

	public int insertBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "insert into board_info(bi_num,bi_title,bi_content,ui_num,credat,cretim,moddat,modtim)";
			sql += "values(seq_bi_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("bi_title"));
			ps.setString(2, board.get("bi_content"));
			ps.setString(3, board.get("ui_num"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "delete from board_info where bi_num=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int updateBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "update board_info set bi_title=?,bi_content=?";
			sql+=" where bi_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("biNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Map<String,String> selectBoard(Map<String,String> board){
		
	try {
		con = DriverManager.getConnection(URL, ID, PWD);
		String sql = "select * from board_info bi, user_info ui ";
		sql += " where bi.ui_num=ui.ui_num ";
		sql += " and bi_num=?";
		sql += " order by bi_num desc";
		ps = con.prepareStatement(sql);
		ps.setString(1,board.get("biNum"));
		rs = ps.executeQuery();
		while (rs.next()) {
			Map<String, String> bi = new HashMap<>();
			bi.put("biNum", rs.getString("bi_num"));
			bi.put("biTitle", rs.getString("bi_title"));
			bi.put("biContent", rs.getString("bi_content"));
			bi.put("uiNum", rs.getString("ui_num"));
			bi.put("uiName", rs.getString("ui_name"));
			bi.put("credat", rs.getString("credat"));
			bi.put("cretim", rs.getString("cretim"));
			bi.put("moddat", rs.getString("moddat"));
			bi.put("modtim", rs.getString("modtim"));
			bi.put("active", rs.getString("active"));
			return bi;
		} 
	} catch (SQLException e1) {
		e1.printStackTrace();
	} finally {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}
	

}
