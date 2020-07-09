package com.chinaedu.taoku.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库访问类
 * @author Administrator
 *
 */
public class DbUtil {

	
	private static final String url = "jdbc:mysql://127.0.0.1:3306/taoku?characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "";


	static {
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 该方法能过够打开数据库的连接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection open() throws SQLException {
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	/**
	 * 关闭数据库连接等资源
	 * @param set:结果集
	 * @param st：命令对象
	 * @param conn：连接对象
	 */
	public static void close(ResultSet set , Statement st, Connection conn) {
		
		try {
			if (set != null) {
				set.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DbUtil.open());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
