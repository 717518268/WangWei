package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.wang.dao.AdvertisingMapper;
import com.wang.pojo.Advertising;
import com.wang.service.AdvertisingServie;
import com.wang.service.RedisTempService;
/**
 * 广告表
 * @author Administrator
 *
 */
@Component
public class AdvertisingServieImpl implements AdvertisingServie{
	
	@Autowired
	private AdvertisingMapper advertisingMapper;
	@Cacheable
	@Override
	public List<Advertising> selectAdvertisingList() {
		List<Advertising> list=advertisingMapper.selectAdvertisingList();
		
		return list;
	}

	@Override
	public Integer deleteAdvertisingId(Integer advertisingid) {
		// TODO Auto-generated method stub
		return advertisingMapper.deleteAdvertisingId(advertisingid);
	}

	@Override
	public Integer insertAdvertising(Advertising advertising) {
		// TODO Auto-generated method stub
		return advertisingMapper.insertAdvertising(advertising);
	}

}
