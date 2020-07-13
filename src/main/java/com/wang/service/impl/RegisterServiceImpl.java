package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.RegisterDao;
import com.wang.pojo.Register;
import com.wang.service.RegisterService;
@Transactional//开启事务
@Component
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	private RegisterDao registerDao;
	
	@Override
	public List<Register> selectRegisterListRanking() {
		// TODO Auto-generated method stub
		return registerDao.selectRegisterListRanking();
	}

	@Override
	public Register selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return registerDao.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateRegisterpPraiseCount(Register register) {
		 
		return registerDao.updateRegisterpPraiseCount(register);
	}
	

}
