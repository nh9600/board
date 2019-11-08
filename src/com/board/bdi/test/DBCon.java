package com.board.bdi.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static String URL;
	private static String ID;
	private static String PWD;
	static {
		InputStream is = DBCon.class.getResourceAsStream("/config/dbconfig.properties");//파일 위치를 알려주고
		System.out.println(is);//경로를 못 찾으면 null
		Properties prop = new Properties();//속성값들을 알려줌
		try {
			prop.load(is);
			URL = prop.getProperty("url");
			ID = prop.getProperty("id");
			PWD = prop.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[]args) {
		Connection con = DBCon.getCon();
		System.out.println(con);
	}
}
