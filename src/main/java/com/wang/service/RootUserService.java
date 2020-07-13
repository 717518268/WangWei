package com.wang.service;

import com.wang.pojo.RootUser;

public interface RootUserService {
	
	public RootUser selectByRootUser(String phone);
	
	public Integer updateMessagent(RootUser rootUser);
	public Integer uMessagentCount(RootUser rootUser);
}
