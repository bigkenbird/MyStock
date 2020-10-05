package bigkenbird.MyStock.dao;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;


import hibernate.util.HibernateUtil;

public abstract class BaseDao<T,E> { //T是vo,E是PK的類別
	
	
	protected Session getSession() {
		return HibernateUtil.getCurrentSession();
	}
	
	@SuppressWarnings({"unchecked" })
	public Class<T> getTypeParameterClass() {
		ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) paramType.getActualTypeArguments()[0];
	}
	
	
	public T findOne(E id) { //用id找物件
		Session session=getSession();
//		Transaction ts=session.beginTransaction();
		T result=session.find(getTypeParameterClass(), id);
//		ts.commit();
		return result;
		
	}
	
	public List<T> findAll(){ //找表單全部物件
		Session session=getSession();
//		Transaction ts=session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getTypeParameterClass());
		query.from(getTypeParameterClass());
		List<T> result=session.createQuery(query).getResultList();
//		ts.commit();
		return result;
	}
	
	public T delete(T obj) { //刪
		Session session=getSession();
//		Transaction ts=session.beginTransaction();
		session.delete(obj);
//		ts.commit();
		return obj;
	}
	
	public T saveOrUpdate(T obj) { //改+增
		Session session=getSession();
//		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(obj);
//		ts.commit();
		return obj;
	}
	
	
	

}
