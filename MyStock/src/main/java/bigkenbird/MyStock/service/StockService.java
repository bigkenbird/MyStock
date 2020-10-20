package bigkenbird.MyStock.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.vo.StockVo;

public interface StockService {
	
	public StockVo saveOrUpdate(StockVo obj);
	
	public StockVo searchByComponent(String component);

	public StockVo saveStock(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
}
