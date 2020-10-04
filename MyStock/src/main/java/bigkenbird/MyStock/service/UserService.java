package bigkenbird.MyStock.service;

import bigkenbird.MyStock.vo.UserVo;

public interface UserService {
	
	public boolean checkLogin(String account,String password);

	public UserVo saveMember(UserVo result);
	

}
