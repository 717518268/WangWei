package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.dao.NumberDao;
import com.wang.pojo.Number;
import com.wang.service.NumberService;
@Component
public class NumberServiceImpl implements NumberService {
	@Autowired
	private NumberDao numberDao;
	@Override
	public List<Number> selectAllNumberList() {
		 
		return numberDao.selectAllNumberList();
	}

	@Override
	public Number selectByNumberId(Integer id) {
		// TODO Auto-generated method stub
		return numberDao.selectByNumberId(id);
	}

	@Override
	public Integer deleteNumberId(Integer id) {
		// TODO Auto-generated method stub
		return numberDao.deleteNumberId(id);
	}

	@Override
	public Integer insertNumber(Number number) {
		// TODO Auto-generated method stub
		return numberDao.insertNumber(number);
	}

	@Override
	public Integer countNumber() {
		// TODO Auto-generated method stub
		return numberDao.countNumber();
	}

	@Override
	public Integer updateNumberCount(Number number) {
		// TODO Auto-generated method stub
		return numberDao.updateNumberCount(number);
	}

	@Override
	public Integer deleteNumberIdSAll(String[] id) {
		// TODO Auto-generated method stub
		return numberDao.deleteNumberIdSAll(id);
	}

}
