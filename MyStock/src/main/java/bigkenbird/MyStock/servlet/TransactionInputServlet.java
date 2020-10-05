package bigkenbird.MyStock.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bigkenbird.MyStock.service.serviceImp.TransactionServiceImp;
import bigkenbird.MyStock.vo.StockVo;
import bigkenbird.MyStock.vo.TransactionVo;
import bigkenbird.MyStock.vo.UserVo;

@WebServlet("/transactioninputservlet")
public class TransactionInputServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static TransactionServiceImp transactionServiceImp=new TransactionServiceImp();
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/transaction/transaction.jsp").forward(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		UserVo testuser=new UserVo("tom1127","tompass","tom",100);
		StockVo teststock=new StockVo("1129","台積電",1000);
		try {
			saveOrUpdate(request,response,testuser,teststock);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	
	public TransactionVo saveOrUpdate(HttpServletRequest request,HttpServletResponse response,UserVo userVo,StockVo stockVo) throws ParseException {
		String stocksymbol=request.getParameter("stocksymbol");
		String component=request.getParameter("component");
		String trans_type=request.getParameter("trans_type");
		Integer shares_num=Integer.valueOf(request.getParameter("shares_num"));
		Integer trans_income=666;
		DateFormat df = DateFormat.getDateInstance();
		Date time=df.parse("2020/01/01");
		TransactionVo result=new TransactionVo(userVo,stockVo,trans_type,shares_num,trans_income,time);
		result=transactionServiceImp.saveOrUpdate(result);
		return result;
		
	}
}