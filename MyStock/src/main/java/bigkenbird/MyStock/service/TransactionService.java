package bigkenbird.MyStock.service;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigkenbird.MyStock.vo.StockVo;
import bigkenbird.MyStock.vo.TransactionVo;
import bigkenbird.MyStock.vo.UserVo;

public interface TransactionService {

	public TransactionVo saveOrUpdate(TransactionVo obj);

	TransactionVo saveOrUpdate(HttpServletRequest request, HttpServletResponse response, UserVo userVo, StockVo stockVo)
			throws ParseException;
}
