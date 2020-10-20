package bigkenbird.MyStock.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bigkenbird.MyStock.service.serviceImp.StockServiceImp;
import bigkenbird.MyStock.util.GetToday;
import bigkenbird.MyStock.vo.StockVo;

@WebServlet("/stockinput")
public class StockInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static StockServiceImp stockServiceImp=new StockServiceImp();
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/stock/stockinput.jsp").forward(request,response);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		StockVo result=stockServiceImp.saveStock(request,response);
		if(result!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("status", "輸入成功");
			request.getRequestDispatcher("/WEB-INF/stock/stockinput.jsp").forward(request, response);
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("status", "輸入失敗");
			request.getRequestDispatcher("/WEB-INF/stock/stockinput.jsp").forward(request, response);
		}
		
	}


	
}
