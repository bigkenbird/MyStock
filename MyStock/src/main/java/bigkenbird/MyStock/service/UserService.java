package bigkenbird.MyStock.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.vo.UserVo;

public interface UserService {
	
	public boolean checkLogin(String account,String password);

	public UserVo saveOrUpdateMember(UserVo result);
	
	public UserVo searchByAccount(String account);
	
	public void checkLogin(String account,String password,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;

	public UserVo saveMember(HttpServletRequest request, HttpServletResponse response);
	

}
