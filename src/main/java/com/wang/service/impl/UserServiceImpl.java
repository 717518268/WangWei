package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.dao.UserDao;
import com.wang.pojo.User;
import com.wang.service.UserService;
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectUserAndGift(Integer uid) {
		User user=userDao.selectUserAndGift(uid);
		return user;
	}

	@Override
	public List<User> selectByAllUser() {
		List<User> list=userDao.selectByAllUser();
		return list;
	}

	@Override
	public User selectFindPhone(String phone) {
		User user=userDao.selectFindPhone(phone);
		return user;
	}

	@Override
	public User selectUidUser(Integer uid) {
		User user=userDao.selectUidUser(uid);
		return user;
	}

	@Override
	public Integer deleteByUserId(Integer uid) {
		int index=userDao.deleteByUserId(uid);
		return index;
	}

	@Override
	public Integer insertUser(User user) {
		int value=userDao.insertUser(user);
		return value;
	}

	@Override
	public Integer countByUser() {
		int count=userDao.countByUser();
		return count;
	}

	@Override
	public Integer updateByGid(User user) {
		int value=userDao.updateByGid(user);
		return value;
	}

}
