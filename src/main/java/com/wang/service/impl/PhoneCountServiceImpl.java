package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.dao.PhoneCountDao;
import com.wang.pojo.PhoneCount;
import com.wang.service.PhoneCountService;
@Component
public class PhoneCountServiceImpl implements PhoneCountService {
	@Autowired
	private PhoneCountDao phoneCountDao;
	
	@Override
	public List<PhoneCount> selectAllPhoneCountList() {
		// TODO Auto-generated method stub
		return phoneCountDao.selectAllPhoneCountList();
	}

	@Override
	public PhoneCount selectByPhoneCountId(int pid) {
		// TODO Auto-generated method stub
		return phoneCountDao.selectByPhoneCountId(pid);
	}

	@Override
	public PhoneCount selectByPhoneCountPhoneValue(String phone) {
		// TODO Auto-generated method stub
		return phoneCountDao.selectByPhoneCountPhoneValue(phone);
	}

	@Override
	public Integer deletePhoneCountGId(Integer pid) {
		// TODO Auto-generated method stub
		return phoneCountDao.deletePhoneCountGId(pid);
	}

	@Override
	public Integer insertPhoneCount(PhoneCount phoneCount) {
		// TODO Auto-generated method stub
		return phoneCountDao.insertPhoneCount(phoneCount);
	}

	@Override
	public Integer countPhoneCount() {
		// TODO Auto-generated method stub
		return phoneCountDao.countPhoneCount();
	}

	@Override
	public Integer updatePhoneCount(PhoneCount phoneCount) {
		// TODO Auto-generated method stub
		return phoneCountDao.updatePhoneCount(phoneCount);
	}

}
