package bigkenbird.MyStock.service.serviceImp;

import java.util.List;

import bigkenbird.MyStock.dao.StockDao;
import bigkenbird.MyStock.service.StockService;
import bigkenbird.MyStock.vo.StockVo;


public class StockServiceImp implements StockService {
	private static StockDao stockDao=new StockDao();

	
	@Override
	public StockVo saveOrUpdate(StockVo obj) {
		stockDao.saveOrUpdate(obj);
		return obj;
	}


	@Override
	public StockVo searchByComponent(String component) {
		List<StockVo>rs=stockDao.findAll();
		for(StockVo element:rs) {
			if(element.getComponent().equals(component)) {
				return element;
			}
		}
		return null;
	}
}
