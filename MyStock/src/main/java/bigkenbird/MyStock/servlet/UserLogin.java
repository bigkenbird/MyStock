package bigkenbird.MyStock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bigkenbird.MyStock.service.serviceImp.UserServiceImp;
import bigkenbird.MyStock.vo.UserVo;


@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static UserServiceImp userServiceImp=new UserServiceImp() ;
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	String account=request.getParameter("account");
	String password=request.getParameter("password");
	checkLogin(account,password,request,response);
	}
	
	@Override  
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		request.getRequestDispatcher("/WEB-INF/login/login.jsp");
	}
	
	public void checkLogin(String account,String password,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		boolean rs=userServiceImp.checkLogin(account, password);
		if(rs) {
			System.out.println("成功登陸");
			UserVo userVo=userServiceImp.searchByAccount(account);
			HttpSession httpssession=request.getSession();
			httpssession.setAttribute("user", userVo);
			request.getRequestDispatcher("/WEB-INF/usermain/usermain.jsp").forward(request, response);
		}
		else {
			System.out.println("登陸失敗");
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		}
	}
	
}
