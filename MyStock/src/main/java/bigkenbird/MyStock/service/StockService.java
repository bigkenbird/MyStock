package bigkenbird.MyStock.service;

import bigkenbird.MyStock.vo.StockVo;

public interface StockService {
	
	public StockVo saveOrUpdate(StockVo obj);
	
	public StockVo searchByComponent(String component);
}
