package bigkenbird.MyStock.service.serviceImp;

import bigkenbird.MyStock.dao.StockDao;
import bigkenbird.MyStock.service.StockService;
import bigkenbird.MyStock.vo.StockVo;


public class StockServiceImp implements StockService {
	private static StockDao stockDao=new StockDao();

	
	@Override
	public StockVo save(StockVo obj) {
		stockDao.save(obj);
		return obj;
	}
}
