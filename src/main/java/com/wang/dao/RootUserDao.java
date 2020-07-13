package com.wang.dao;

import com.wang.pojo.RootUser;

public interface RootUserDao {
	
	public RootUser selectByRootUser(String phone);
	
	public Integer updateMessagent(RootUser rootUser);
	
	public Integer uMessagentCount(RootUser rootUser);
}
