

package com.willow.core.system.service.impl;

import com.willow.common.model.ResultList;
import com.willow.common.page.Page;
import com.willow.core.system.dao.ItcastUserDao;
import com.willow.core.system.model.ItcastUser;
import com.willow.core.system.model.query.ItcastUserQuery;
import com.willow.core.system.service.ItcastUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ItcastUserServiceImpl implements ItcastUserService {
	@Resource
	private ItcastUserDao itcastUserDao;
	
	public ItcastUser getItcastUserById(Integer itcastUserId) {
		return itcastUserDao.getItcastUserById(itcastUserId);
	}

	public boolean insertItcastUser(ItcastUser itcastUser) {
		itcastUserDao.insertItcastUser(itcastUser);
		return true;
	}

	public ResultList queryItcastUser(ItcastUserQuery itcastUserQuery,Page page){
		ResultList resultList = new ResultList();
		page.setTotalResult(itcastUserDao.getCountItcastUser(itcastUserQuery));

    resultList.setPage(page);
    resultList.setList(itcastUserDao.queryItcastUser(itcastUserQuery,page));

		return resultList;
	}
	
	public List<ItcastUser> queryItcastUser(ItcastUserQuery itcastUserQuery){
		return itcastUserDao.queryItcastUser(itcastUserQuery);
	}

	public void updateItcastUser(ItcastUser itcastUser) {
		itcastUserDao.updateItcastUser(itcastUser);
	}


	public void deleteItcastUser(Integer itcastUserId){
		itcastUserDao.deleteItcastUser(itcastUserId);
	}
}
