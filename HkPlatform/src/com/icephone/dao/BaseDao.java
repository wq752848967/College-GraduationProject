package com.icephone.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	public void add(Object o);

	public void update(Object o);

	public void delete(Object o);
	
	

	
	
	public <T> T getById(Class<T> clazz, Serializable id);
	
	public <T> List<T> getAll(T t, String order);
	
	
	
	
	
	
}
