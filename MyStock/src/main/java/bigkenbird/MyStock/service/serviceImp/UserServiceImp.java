package bigkenbird.MyStock.service.serviceImp;

import java.util.List;

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

}
