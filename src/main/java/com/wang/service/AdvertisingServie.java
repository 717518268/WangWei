package com.wang.service;

import com.wang.pojo.Advertising;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisingServie{
    
	/**
	 * 查全部
	 * @return
	 */
	public List<Advertising>selectAdvertisingList();
	
	/**
	 * 根据id
	 * 删除
	 * @param advertisingid
	 * @return
	 */
	public Integer deleteAdvertisingId(Integer advertisingid);
	
	/**
	 * 添加一个广告
	 * @param advertising
	 * @return
	 */
	public Integer insertAdvertising(Advertising advertising);
}