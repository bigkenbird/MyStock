package hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	
	
	public static StandardServiceRegistry serviceRegistry=
			new StandardServiceRegistryBuilder().configure().build();
	
	
	public static SessionFactory sessionFactory=
			new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	
	
	
	public static StandardServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getCurrentSession(){
		Session session=sessionFactory.getCurrentSession();
		return session;
	}
	
	public void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}

}
