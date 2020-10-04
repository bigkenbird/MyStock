package bigkenbird.MyStock.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bigkenbird.MyStock.service.serviceImp.UserServiceImp;


@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static UserServiceImp userServiceImp=new UserServiceImp() ;
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
	String account=request.getParameter("account");
	String password=request.getParameter("password");
	checkLogin(account,password);
	}
	
	@Override  
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkLogin(String account,String password) {
		boolean rs=userServiceImp.checkLogin(account, password);
		if(rs) {
			System.out.println("成功登陸");
		}
		else {
			System.out.println("登陸失敗");
		}
	}
	
}
