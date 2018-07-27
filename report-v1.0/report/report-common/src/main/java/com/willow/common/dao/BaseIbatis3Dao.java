package com.willow.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author badqiu
 */
public interface BaseIbatis3Dao<E,PK extends Serializable>{

	public Object getById(PK id);
	
	public void delete(PK id);
	
	public void insert(E entity);
	public void insert(String statementName);
	public void insert(String statementName, E entity);
	
	public void update(E entity);
	public void update(String statementName);
	public void update(String statementName, E entity);
    public void batchUpdate(String statementName, Object object);
	
	public Object selectOne(String statementName, Object o);

	public List<E> selectList(String statementName, Object o) ;
	public List<E> selectList(String statementName) ;
	
}
