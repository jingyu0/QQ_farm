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
		//cmd�������Ĳ���������
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
	 * ע������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û��ύ����Ϣ
		request.setCharacterEncoding("utf-8");
		String usrname = request.getParameter("usrname");
		String usrpwd = request.getParameter("usrpwd");
		String usremail = request.getParameter("usremail");
		
		
		UserDao dao = new UserDao();
		Userinfo u = new Userinfo();
		u.setUsrname(usrname);
		u.setUsrsex("Ů");
		u.setUsrphone("13319572935");
		u.setUsrpwd(usrpwd);
		u.setUsremail(usremail);
		dao.add(u);
		
		response.sendRedirect("register.htm");
				
	}
	
	/**
	 * ��¼����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����û���¼
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name+"\t"+pwd);
		//���˺�������֯��Ϊһ���û�����
		Userinfo u = new Userinfo();
		u.setUsrname(name);
		u.setUsrpwd(pwd);
		
		UserDao dao = new UserDao();
		Userinfo user = dao.findUser(u);
		if(user==null) {
			//�˺����벻�ԣ�ҳ��ת����¼ҳ��ȥ
			//����ת��
			request.getRequestDispatcher("login.htm").forward(request, response);
		}else {
			//��¼�ɹ�����ҳ��ת����
			response.sendRedirect("index.html");
			
		}
	}

}
