package bigkenbird.MyStock.service.serviceImp;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bigkenbird.MyStock.dao.UserDao;
import bigkenbird.MyStock.service.UserService;
import bigkenbird.MyStock.util.Encryption;
import bigkenbird.MyStock.vo.UserVo;

public class UserServiceImp implements UserService {
	
	private static UserDao userDao=new UserDao();

	@Override
	public boolean checkLogin(String account,String password) {
		List<UserVo> rs=userDao.seachByAccount(account);
		if(rs!=null) {
			String element_password;
			for(UserVo element:rs) {
				element_password=element.getPassword().toString();
				if(element_password.equals(password)) {
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
		public UserVo saveMember(HttpServletRequest request,HttpServletResponse response) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		Integer money=Integer.valueOf(request.getParameter("money"));
		byte[] decrypted_password=Encryption.Encrytor(password);
		UserVo result=new UserVo(account,decrypted_password,name,money);
		UserVo rs=saveOrUpdateMember(result);
		return result;
		
	}

}	
	


