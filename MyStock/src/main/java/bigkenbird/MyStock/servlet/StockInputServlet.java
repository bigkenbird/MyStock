package bigkenbird.MyStock.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bigkenbird.MyStock.service.serviceImp.StockServiceImp;
import bigkenbird.MyStock.vo.StockVo;

@WebServlet("/stockinput")
public class StockInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StockServiceImp stockServiceImp=new StockServiceImp();
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getRequestDispatcher("/WEB-INF/stock/stockinput.jsp");
	}
	
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		StockVo result=saveStock(request,response);
		if(result!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("status", "輸入成功");
			request.getRequestDispatcher("/WEB-INF/stock/stockinput.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("status", "輸入失敗");
			request.getRequestDispatcher("/WEB-INF/stock/stockinput.jsp");
		}
		
	}


	public StockVo saveStock(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String stocksymbol=request.getParameter("stocksymbol");
		String component=request.getParameter("component");
		Integer price=Integer.valueOf(request.getParameter("price"));
		StockVo obj=new StockVo(stocksymbol,component,price);
		stockServiceImp.saveOrUpdate(obj);
		return obj;
		
		
	}

}
