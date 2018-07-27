

package com.willow.core.system.dao.impl;

import java.util.*;

import com.willow.common.dao.impl.BaseIbatis3DaoImpl;
import com.willow.common.dynamicds.DataSourceConst;
import com.willow.common.dynamicds.DataSourceHandle;
import com.willow.common.page.Page;
import com.willow.core.system.dao.ItcastUserDao;
import com.willow.core.system.model.ItcastUser;
import com.willow.core.system.model.query.ItcastUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ItcastUserDaoImpl extends BaseIbatis3DaoImpl<ItcastUser,Integer> implements ItcastUserDao {
	public ItcastUser getItcastUserById(Integer itcastUserId) {
		DataSourceHandle.setDataSourceType(DataSourceConst.READ);
		return (ItcastUser)this.getById(itcastUserId);
	}

	public void insertItcastUser(ItcastUser itcastUser) {
		DataSourceHandle.setDataSourceType(DataSourceConst.WRITE);
		this.insert(itcastUser);
	}

	public int getCountItcastUser(ItcastUserQuery itcastUserQuery){
		DataSourceHandle.setDataSourceType(DataSourceConst.READ);
		return (Integer) this.selectOne("getCountItcastUser",itcastUserQuery);
	}
	
	public List<ItcastUser> queryItcastUser(ItcastUserQuery itcastUserQuery,Page page){
		DataSourceHandle.setDataSourceType(DataSourceConst.READ);
		return this.selectList("listItcastUser", itcastUserQuery,page.getCurrentResult(),page.getPageSize());
	}
	
	public List<ItcastUser> queryItcastUser(ItcastUserQuery itcastUserQuery){
		DataSourceHandle.setDataSourceType(DataSourceConst.READ);
		return this.selectList("listItcastUser", itcastUserQuery);
	}

	public void updateItcastUser(ItcastUser itcastUser) {
		DataSourceHandle.setDataSourceType(DataSourceConst.WRITE);
		this.update(itcastUser);
	}


	public void deleteItcastUser(Integer itcastUserId){
		DataSourceHandle.setDataSourceType(DataSourceConst.WRITE);
		this.delete(itcastUserId);
	}
}
