package com.fh.dao;

import java.io.Serializable;

public interface Dao<T> {
	public void save(T t);
	public void update(T t);
	public T findById(Serializable id);
}
