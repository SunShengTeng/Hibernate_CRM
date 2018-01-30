package cn.sst.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctc.wstx.dtd.SeqContentSpec;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	static{
		
	   Configuration configuration = new Configuration().configure();
	   sessionFactory = configuration.buildSessionFactory();
	   
	}
	
	
	/**
	 * 获得HibernateSession
	 * 
	 * @return
	 */
	public static Session openSession(){
		
		return sessionFactory.openSession();
	}
	
	/**
	 * 获得Hibernate的SessionFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
        // TODO 由于目前hibernate.cfg.xml不支持配置hibernate.current_session_context_clas故暂使用openSession的方式

		return sessionFactory;
	}
	
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
}
