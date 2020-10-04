package bigkenbird.MyStock.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.service.serviceImp.UserServiceImp;
import bigkenbird.MyStock.vo.UserVo;


@WebServlet("/usersignup")
public class UserSignUpServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static UserServiceImp userServiceImp;
	
	@Override
	public void doGet(HttpServletRequest resquest,HttpServletResponse response) {
		try {
			response.sendRedirect("usersignup.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		saveMember(request,response);
		
	}
	
	public UserVo saveMember(HttpServletRequest request,HttpServletResponse response) {
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		Integer money=Integer.valueOf(request.getParameter("money"));
		UserVo result=new UserVo(account,password,name,money);
		UserVo rs=userServiceImp.saveMember(result);
		return result;
		
	}

}
