package bigkenbird.MyStock.service.serviceImp;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.dao.StockDao;
import bigkenbird.MyStock.service.StockService;
import bigkenbird.MyStock.util.GetToday;
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
	
	@Override
	public StockVo saveStock(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String stocksymbol=request.getParameter("stocksymbol");
		String component=request.getParameter("component");
		Integer price=Integer.valueOf(request.getParameter("price"));
		StockVo obj=new StockVo(stocksymbol,component,price, GetToday.today);
		saveOrUpdate(obj);
		return obj;
		
		
	}

}
