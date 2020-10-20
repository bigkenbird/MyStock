package bigkenbird.MyStock.service.serviceImp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bigkenbird.MyStock.dao.UserDao;
import bigkenbird.MyStock.service.UserService;
import bigkenbird.MyStock.vo.UserVo;

public class UserServiceImp implements UserService {
	
	private static UserDao userDao=new UserDao();

	@Override
	public boolean checkLogin(String account,String password) {
		List<UserVo> rs=userDao.seachByAccount(account);
		if(rs!=null) {
			for(UserVo element:rs) {
				if(element.getPassword()==password) {
					return true;
				}
				return false;
			}
		}
		System.out.println("查無此帳號");
		return false;
	}

	@Override
	public UserVo saveOrUpdateMember(UserVo result) {
		userDao.saveOrUpdate(result);
		return result;
	}

	@Override
	public UserVo searchByAccount(String account) {
		List<UserVo> rs=userDao.seachByAccount(account);
		if(rs.get(0)!=null) {
			return rs.get(0);
		}
		return null;
	}

	@Override
	public void checkLogin(String account, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean rs=checkLogin(account, password);
		if(rs) {
			System.out.println("成功登陸");
			UserVo userVo=searchByAccount(account);
			HttpSession httpssession=request.getSession();
			httpssession.setAttribute("user", userVo);
			request.getRequestDispatcher("/WEB-INF/usermain/usermain.jsp").forward(request, response);
		}
		else {
			System.out.println("登陸失敗");
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		}
	}
	@Override
		public UserVo saveMember(HttpServletRequest request,HttpServletResponse response) {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		Integer money=Integer.valueOf(request.getParameter("money"));
		UserVo result=new UserVo(account,password,name,money);
		UserVo rs=saveOrUpdateMember(result);
		return result;
		
	}

}	
	


