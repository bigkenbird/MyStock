package bigkenbird.MyStock.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;

@WebFilter(filterName="BaseFilter",urlPatterns= {"/*"})
public class BaseFilter implements Filter {

	@Override //設定request值屬性
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
	Session session=HibernateUtil.getCurrentSession(); //設定session自動commit
	try {
		session.beginTransaction();
		filterChain.doFilter(request, response);
		session.getTransaction().commit();
	}catch(Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
	}
	finally{
        if(session != null){
            session.close();
        }
	}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
}
