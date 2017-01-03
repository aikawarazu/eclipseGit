package com.fh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
	private final static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration cfg = new Configuration();
	private static SessionFactory sessionFactory; 
	static {
		try {
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public final static Session getSession() {
		Session session = threadLocal.get();
		if (session ==null || !session.isOpen()) {
			session = (sessionFactory!=null)?sessionFactory.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	
	
}
