

package com.willow.core.system.service;

import java.util.List;

import com.willow.common.model.ResultList;
import com.willow.common.page.Page;
import com.willow.core.system.model.ItcastUser;
import com.willow.core.system.model.query.ItcastUserQuery;
import org.springframework.stereotype.Service;


public interface ItcastUserService {
	public ItcastUser getItcastUserById(Integer itcastUserId);

	public boolean insertItcastUser(ItcastUser itcastUser) ;

	public ResultList queryItcastUser(ItcastUserQuery itcastUserQuery,Page page);
	
	public List<ItcastUser> queryItcastUser(ItcastUserQuery itcastUserQuery);

	public void updateItcastUser(ItcastUser itcastUser);

	public void deleteItcastUser(Integer itcastUserId);
}
