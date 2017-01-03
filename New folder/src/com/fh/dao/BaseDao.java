package com.fh.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fh.utils.HibernateSessionUtil;

public abstract class BaseDao<T> implements Dao<T> {
    Class<T> clazz = null;
    Session session = HibernateSessionUtil.getSession();
    public BaseDao(){
    	ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println(clazz);
    }
    @Override
    public void save(T t) {
    	Transaction transaction = session.beginTransaction();
    	session.save(t);
    	transaction.commit();
    	session.close();
    }
    
    @Override
    public void update(T t) {
    	session.update(t);
    }
    
    @Override
    public T findById(Serializable id) {
    	return session.get(clazz,id);
    }
    
}
