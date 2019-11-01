package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.board.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID="bdi";
	private static final String PWD="12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public Map<String, String> selectUser(Map<String, String> user) {
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "select * from user_info where ui_id=? and ui_pwd=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,user.get("uiId"));//String 두개를 만드는게 아니라 Map을 만드는 것임
			ps.setString(2,user.get("uiPwd"));//서비스에서 입력한게 들어감(put한거) 
			rs=ps.executeQuery();//실행
			if(rs.next()) {//넥스트할경운 밑으로 내려서 데이터가 있으면 리턴 ture, 한번만 보면 되니까 if
				user.put("uiNum",rs.getString("ui_num"));
				user.put("credat",rs.getString("credat"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			    if(con!=null) {
					con.close();
			      }
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}

		return null;
	}
	
	public Map<String,Object> signupinfo(Map<String,Object> userinfo){
		try {
			con=DriverManager.getConnection(URL,PWD,ID);
			String sql = "insert into user_info(ui_num,ui_name,ui_id,ui_pwd,credat,cretim,moddat,modtim)";
			sql+="values(seq_ui_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'), to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd')";
			ps.setString(1,"uiName");
			ps.setString(2,"uiId");
			ps.setString(1,"uiPwd");
			rs=ps.executeQuery();
			//if(ps.executeUpdate()==1) {
				//Map<String,Object> sign = new HashMap<String,Object>();
				//sign.put("uiNum",rs.getString("ui_num"));
				//sign.put("credat",rs.getString("credat"));
				//return sign;
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			    if(con!=null) {
					con.close();
			      }
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}

		return null;
	}
		
	
	public static void main(String[]args) {
		UserDAO udao = new UserDAOImpl();
		Map<String,String> user = new HashMap<>();
		user.put("uiId","gksmf");
		user.put("uiPwd","123456");
		user = udao.selectUser(user);
		System.out.println(user);//값이 잘 나오는지 체크!
	}

}
