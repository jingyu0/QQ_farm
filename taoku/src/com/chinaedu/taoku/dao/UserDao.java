package com.chinaedu.taoku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chinaedu.taoku.pojo.Userinfo;
import com.chinaedu.taoku.utils.DbUtil;

/**
 * 一个标准的dao应该是包括(增，删，改，查)
 * @author Administrator
 *
 */
public class UserDao{


	/**
	 * 
	 * @param user:登录的用户对象
	 * @return：如果登录成功，那么返回该用户对象，如果登录失败，返回Null
	 */
	public Userinfo findUser(Userinfo user) {
		
		String sql = "select * from userinfo where usrname=? and usrpwd=?";
		
		try {
			//建立连接
			Connection conn = DbUtil.open();
			//创建命令对象
			PreparedStatement pst = conn.prepareStatement(sql);
			//设置参数值
			pst.setString(1, user.getUsrname());
			pst.setString(2, user.getUsrpwd());
			//执行命令
			ResultSet set = pst.executeQuery();
			Userinfo u = null;
			if(set.next()) {
				int no =set.getInt(1);
				String name = set.getString(2);
				String pwd = set.getString(3);
				u = new Userinfo();
				u.setUsrid(no);
				u.setUsrname(name);
				u.setUsrpwd(pwd);
			
			}			
			//关闭连接
			DbUtil.close(null, pst, conn);
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void add(Userinfo user) {
		
		
		String sql = "insert into userinfo values(null,?,?,?,?,?)";
		
		try {
			//建立连接
			Connection conn = DbUtil.open();
			//创建命令对象
			PreparedStatement pst = conn.prepareStatement(sql);
			//设置参数值
			pst.setString(1, user.getUsrname());
			pst.setString(2, user.getUsrpwd());
			pst.setString(3, user.getUsrsex());
			pst.setString(4, user.getUsrphone());
			pst.setString(5, user.getUsremail());
			//执行命令
			pst.execute();
			//关闭连接
			DbUtil.close(null, pst, conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
