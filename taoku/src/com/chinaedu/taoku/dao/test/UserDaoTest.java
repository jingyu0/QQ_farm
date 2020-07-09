package com.chinaedu.taoku.dao.test;

import org.junit.Before;
import org.junit.Test;

import com.chinaedu.taoku.dao.UserDao;
import com.chinaedu.taoku.pojo.Userinfo;

public class UserDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		UserDao dao = new UserDao();
		Userinfo u = new Userinfo();
		u.setUsrname("Œ‚ª€Ê√");
		u.setUsrsex("≈Æ");
		u.setUsrphone("13319572935");
		u.setUsrpwd("123");
		u.setUsremail("wht@163.com");
		dao.add(u);
	}
	
	@Test
	public void testFindUser() {
		UserDao dao = new UserDao();
		Userinfo u = new Userinfo();
		u.setUsrname("qld123");		
		u.setUsrpwd("123456");
		
		Userinfo user = dao.findUser(u);
		System.out.println(user);
	}

}
