package com.chinaedu.taoku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chinaedu.taoku.pojo.Userinfo;
import com.chinaedu.taoku.utils.DbUtil;

/**
 * һ����׼��daoӦ���ǰ���(����ɾ���ģ���)
 * @author Administrator
 *
 */
public class UserDao{


	/**
	 * 
	 * @param user:��¼���û�����
	 * @return�������¼�ɹ�����ô���ظ��û����������¼ʧ�ܣ�����Null
	 */
	public Userinfo findUser(Userinfo user) {
		
		String sql = "select * from userinfo where usrname=? and usrpwd=?";
		
		try {
			//��������
			Connection conn = DbUtil.open();
			//�����������
			PreparedStatement pst = conn.prepareStatement(sql);
			//���ò���ֵ
			pst.setString(1, user.getUsrname());
			pst.setString(2, user.getUsrpwd());
			//ִ������
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
			//�ر�����
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
			//��������
			Connection conn = DbUtil.open();
			//�����������
			PreparedStatement pst = conn.prepareStatement(sql);
			//���ò���ֵ
			pst.setString(1, user.getUsrname());
			pst.setString(2, user.getUsrpwd());
			pst.setString(3, user.getUsrsex());
			pst.setString(4, user.getUsrphone());
			pst.setString(5, user.getUsremail());
			//ִ������
			pst.execute();
			//�ر�����
			DbUtil.close(null, pst, conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
