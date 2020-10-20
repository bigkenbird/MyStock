package bigkenbird.MyStock.service.serviceImp;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.dao.TransactionDao;
import bigkenbird.MyStock.service.TransactionService;
import bigkenbird.MyStock.util.GetToday;
import bigkenbird.MyStock.vo.StockVo;
import bigkenbird.MyStock.vo.TransactionVo;
import bigkenbird.MyStock.vo.UserVo;

public class TransactionServiceImp implements TransactionService {

	
	private static TransactionDao transactionDao=new TransactionDao();
	
	@Override
	public TransactionVo saveOrUpdate(TransactionVo obj) {
		transactionDao.saveOrUpdate(obj);
		return obj;
	}
	
	@Override
	public TransactionVo saveOrUpdate(HttpServletRequest request,HttpServletResponse response,UserVo userVo,StockVo stockVo) throws ParseException {
		String trans_type=request.getParameter("trans_type");
		Integer shares_num=Integer.valueOf(request.getParameter("shares_num"));
		Integer trans_income=666;
		TransactionVo result=new TransactionVo(userVo,stockVo,trans_type,shares_num,trans_income,GetToday.today);
		result=saveOrUpdate(result);
		return result;
		
	}

}
