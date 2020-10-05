package bigkenbird.MyStock.service.serviceImp;

import bigkenbird.MyStock.dao.TransactionDao;
import bigkenbird.MyStock.service.TransactionService;
import bigkenbird.MyStock.vo.TransactionVo;

public class TransactionServiceImp implements TransactionService {

	
	private static TransactionDao transactionDao=new TransactionDao();
	
	@Override
	public TransactionVo saveOrUpdate(TransactionVo obj) {
		transactionDao.saveOrUpdate(obj);
		return obj;
	}

}
