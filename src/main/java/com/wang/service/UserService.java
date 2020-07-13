package com.wang.service;

import java.util.List;

import com.wang.pojo.User;

public interface UserService {
	/**
	 * 根据用户uid查询用户获得的礼物
	 * 一对一查询
	 * @param uid
	 * @return
	 */
	public User selectUserAndGift(Integer uid);
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User>selectByAllUser();
	/**
	 * 检查电话是否已经发送过了
	 * @param phone
	 * @return
	 */
	public User selectFindPhone(String phone);
	/**
	 * 根据uid查询用户
	 * @param uid
	 * @return
	 */
	public User selectUidUser(Integer uid);
	/**
	 * 删除
	 * @param uid
	 * @return
	 */
	public Integer deleteByUserId(Integer uid);
	/**
	 * phone, name,gid
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * 查总数
	 * @return
	 */
	public Integer countByUser();
	
	/**
	 * 根据用户uid设置修改对应的礼物gid
	 * @param user
	 * @return
	 */
	public Integer updateByGid(User user);
	
	
	
}
