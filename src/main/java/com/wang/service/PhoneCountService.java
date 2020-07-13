package com.wang.service;

import java.util.List;

import com.wang.pojo.PhoneCount;
/**
 * 统计手机号的动态表
 * @author Administrator
 *
 */
public interface PhoneCountService {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<PhoneCount>selectAllPhoneCountList();
	
	public PhoneCount selectByPhoneCountId(int pid);
	/**
	 * 根据
	 * @param phone
	 * @return
	 */
	public PhoneCount selectByPhoneCountPhoneValue(String phone);
	public Integer deletePhoneCountGId(Integer pid);
	
	/**
	 * phone and count
	 * @param phoneCount
	 * @return
	 */
	public Integer insertPhoneCount(PhoneCount phoneCount);
	
	public Integer countPhoneCount();
	/**
	 * 修改次数
	 * @param phoneCount
	 * @return
	 */
	public Integer updatePhoneCount(PhoneCount phoneCount);
	
}
