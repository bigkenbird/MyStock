package bigkenbird.MyStock.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.service.serviceImp.StockServiceImp;
import bigkenbird.MyStock.service.serviceImp.TransactionServiceImp;
import bigkenbird.MyStock.service.serviceImp.UserServiceImp;
import bigkenbird.MyStock.util.GetToday;
import bigkenbird.MyStock.vo.StockVo;
import bigkenbird.MyStock.vo.TransactionVo;
import bigkenbird.MyStock.vo.UserVo;


@WebServlet("/transactioninputservlet")
public class TransactionInputServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static TransactionServiceImp transactionServiceImp=new TransactionServiceImp();
	
	private static UserServiceImp userServiceImp=new UserServiceImp();
	
	private static StockServiceImp stockServiceImp=new StockServiceImp();
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/transaction/transaction.jsp").forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		String account=request.getParameter("account");
		String component=request.getParameter("component");
		UserVo testuser=userServiceImp.searchByAccount(account);
		StockVo teststock=stockServiceImp.searchByComponent(component);
		try {
			transactionServiceImp.saveOrUpdate(request,response,testuser,teststock);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	
	
	
	
}