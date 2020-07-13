package com.wang.service;

 
import java.util.List;

import com.wang.pojo.Gift;

 



public interface  GiftService{
     
	/**
	 * 根据gid一对一查询gift和user两张表
	 * @param gid
	 * @return
	 */
	public Gift selectGiftDaoOneUser(Integer gid );
	
	/**
	 * 展示所有的礼物
	 * @return
	 */
	public List<Gift> selectAllGiftList();
	/**
	 * 根据gid查询
	 * @param gid
	 * @return
	 */
	public Gift selectByGiftGId(Integer gid);
	
	/**
	 * 根据gid删除
	 * @param gid
	 * @return
	 */
	public Integer deleteByGiftGId(Integer gid);
	
	/**
	 * 添加礼物
	 * @param gift
	 * @return
	 */
	public Integer insertGift(Gift gift);
	/**
	 * 查礼物总数
	 * @return
	 */
	public Integer countByGift();
	
	/**
	 * 根据gid修改uid
	 * 将此礼物的外键uid，设置给对应的用户uid
	 * @param gift
	 * @return
	 */
	public int updateGiftGid(Gift gift);
	
	/**
	 * 根据gid修改库存，库存最后不要大于1
	 * @param gift
	 * @return
	 */
	public int updateGiftCount(Gift gift);
	
}