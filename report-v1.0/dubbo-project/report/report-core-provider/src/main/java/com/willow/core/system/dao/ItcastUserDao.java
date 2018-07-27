package com.willow.core.system.dao;

import java.util.*;

import com.willow.common.page.Page;
import com.willow.core.system.model.ItcastUser;
import com.willow.core.system.model.query.ItcastUserQuery;
import org.springframework.stereotype.Repository;


@Repository
public interface ItcastUserDao {
	public ItcastUser getItcastUserById(Integer itcastUserId);

	public void insertItcastUser(ItcastUser itcastUser);

	public int getCountItcastUser(ItcastUserQuery itcastUserQuery);
	
	public List<ItcastUser> queryItcastUser(ItcastUserQuery itcastUserQuery, Page page);
	
	public List<ItcastUser> queryItcastUser(ItcastUserQuery itcastUserQuery);

	public void updateItcastUser(ItcastUser itcastUser);

	public void deleteItcastUser(Integer itcastUserId);
}
