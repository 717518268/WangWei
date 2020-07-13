package com.wang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.dao.RootUserDao;
import com.wang.pojo.RootUser;
import com.wang.service.RootUserService;
@Service
public class RootUserServiceImpl implements RootUserService {
	@Autowired
	private RootUserDao rootUserDao;
	
	@Override
	public RootUser selectByRootUser(String phone) {
		// TODO Auto-generated method stub
		return rootUserDao.selectByRootUser(phone);
	}

	@Override
	public Integer updateMessagent(RootUser rootUser) {
		// TODO Auto-generated method stub
		return rootUserDao.updateMessagent(rootUser);
	}

	@Override
	public Integer uMessagentCount(RootUser rootUser) {
		// TODO Auto-generated method stub
		return rootUserDao.uMessagentCount(rootUser);
	}

}
