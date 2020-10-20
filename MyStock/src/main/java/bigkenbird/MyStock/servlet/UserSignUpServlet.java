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


@WebServlet("/usersignup")
public class UserSignUpServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static UserServiceImp userServiceImp=new UserServiceImp();
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/signup/usersignup.jsp").forward(request,response);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		UserVo rs=userServiceImp.saveMember(request,response);
		HttpSession session=request.getSession();
		if(rs!=null) {
			session.setAttribute("user", rs);
			request.getRequestDispatcher("/WEB-INF/usermain/usermain.jsp").forward(request,response);
		}
		else {
			session.setAttribute("status", "NOT Correct");
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request,response);
		}
		
	}
	
	
}
