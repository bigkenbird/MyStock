package bigkenbird.MyStock.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import bigkenbird.MyStock.vo.UserVo;
import hibernate.util.HibernateUtil;


public class UserDao extends BaseDao<UserVo, Integer> {
	
	public List<UserVo> seachByAccount(String account) { 
		List<UserVo> list= new ArrayList<UserVo>();
	Session session=HibernateUtil.getCurrentSession();
//	Transaction ts=session.beginTransaction();
	String sqlString="FROM UserVo WHERE account='"+account+"'";
	Query<UserVo> query=session.createQuery(sqlString, UserVo.class);
	list=query.getResultList();
//	ts.commit();
	return list;
	}
	
	
}
