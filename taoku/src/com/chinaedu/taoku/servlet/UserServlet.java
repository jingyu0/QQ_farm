package com.chinaedu.taoku.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinaedu.taoku.dao.UserDao;
import com.chinaedu.taoku.pojo.Userinfo;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//cmd代表具体的操作，科室
		String cmd = request.getParameter("cmd");
		if("login".equals(cmd)) {
			this.doLogin(request, response);
		}
		if("reg".equals(cmd)) {
			this.doReg(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * 注册请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户提交的信息
		request.setCharacterEncoding("utf-8");
		String usrname = request.getParameter("usrname");
		String usrpwd = request.getParameter("usrpwd");
		String usremail = request.getParameter("usremail");
		
		
		UserDao dao = new UserDao();
		Userinfo u = new Userinfo();
		u.setUsrname(usrname);
		u.setUsrsex("女");
		u.setUsrphone("13319572935");
		u.setUsrpwd(usrpwd);
		u.setUsremail(usremail);
		dao.add(u);
		
		response.sendRedirect("register.htm");
				
	}
	
	/**
	 * 登录请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理用户登录
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name+"\t"+pwd);
		//将账号密码组织成为一个用户对象
		Userinfo u = new Userinfo();
		u.setUsrname(name);
		u.setUsrpwd(pwd);
		
		UserDao dao = new UserDao();
		Userinfo user = dao.findUser(u);
		if(user==null) {
			//账号密码不对，页面转到登录页面去
			//请求转发
			request.getRequestDispatcher("login.htm").forward(request, response);
		}else {
			//登录成功，将页面转到？
			response.sendRedirect("index.html");
			
		}
	}

}
