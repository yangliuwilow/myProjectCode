package com.willow.common.dao.impl;



import com.willow.common.dao.BaseIbatis3Dao;
import com.willow.common.util.GenericsUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


/**
 * @author badqiu
 * @version 1.0
 */
public class BaseIbatis3DaoImpl<E,PK extends Serializable> extends SqlSessionDaoSupport implements BaseIbatis3Dao<E,PK> {
    protected final Log log = LogFactory.getLog(getClass());
	protected Class<E> entityClass;
	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	public BaseIbatis3DaoImpl() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	public Object getById(PK primaryKey) {
        Object object = getSqlSession().selectOne(getFindByPrimaryKeyQuery(), primaryKey);
        return object;
    }
	
	public Object getById(String primaryKey) {
        Object object = getSqlSession().selectOne(getFindByPrimaryKeyQuery(), primaryKey);
        return object;
    }
    
	public void delete(PK id) {
		getSqlSession().delete(getDeleteQuery(), id);
	}
	
	public void delete(String id) {
		getSqlSession().delete(getDeleteQuery(), id);
	}
	public void delete(E entity) {
		getSqlSession().delete(getDeleteQuery(), entity);
	}
	
	public void delete(String statementName,E entity) {
		getSqlSession().delete(entityClass.getName() +"."+statementName, entity);
	}
	
    public void insert(E entity) {
		getSqlSession().insert(getInsertQuery(), entity);
    }
    public void insert(String statementName) {
		getSqlSession().insert(entityClass.getName() +"."+statementName);
    }
    public void insert(String statementName,E entity) {
		getSqlSession().insert(entityClass.getName() +"."+statementName, entity);  	
    }
	public void update(E entity) {
		getSqlSession().update(getUpdateQuery(), entity);
	}
	public void update(String statementName) {
		getSqlSession().update(entityClass.getName() +"."+statementName);
	}
	public void update(String statementName,E entity) {
		getSqlSession().update(entityClass.getName() +"."+statementName, entity);
	}
    public void batchUpdate(String statementName,Object object) {
        getSqlSession().update(entityClass.getName() +"."+statementName, object);
    }
	/**
	 * 根据sql名查询对象
	 * @param statementName
	 * @param
	 * @return
	 */
	public Object selectOne(String statementName, Object o) {
		return getSqlSession().selectOne(entityClass.getName() +"."+statementName, o);
	}
	public List<E> selectList(String statementName, Object o) {
		return getSqlSession().selectList(entityClass.getName() + "." + statementName, o);
	}
	public List<E> selectList(String statementName, Object o,int offset,int limit) {
		return getSqlSession().selectList(entityClass.getName() +"."+statementName, o,new RowBounds(offset,limit));
	}

	public List<E> selectList(String statementName, int offset,int limit) {
		return getSqlSession().selectList(entityClass.getName() +"."+statementName,new RowBounds(offset,limit));
	}
	public List<E> selectList(String statementName) {
		return getSqlSession().selectList(entityClass.getName() +"."+statementName);
	}
    public String getFindByPrimaryKeyQuery() {
        return entityClass.getName()+".getById";
    }

    public String getInsertQuery() {
        return entityClass.getName()+".insert";
    }

    public String getUpdateQuery() {
    	return entityClass.getName()+".update";
    }

    public String getDeleteQuery() {
    	return entityClass.getName()+".delete";
    }

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
