package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.dao.GiftDao;
import com.wang.pojo.Gift;
import com.wang.service.GiftService;
@Component
public class GiftServiceImpl implements GiftService {
	
	@Autowired
	private GiftDao giftDao;
	
	@Override
	public Gift selectGiftDaoOneUser(Integer gid) {
		Gift gift=giftDao.selectGiftDaoOneUser(gid);
		return gift;
	}

	@Override
	public List<Gift> selectAllGiftList() {
		List<Gift>list=giftDao.selectAllGiftList();
		return list;
	}

	@Override
	public Gift selectByGiftGId(Integer gid) {
		Gift gift=giftDao.selectByGiftGId(gid);
		return gift;
	}

	@Override
	public Integer deleteByGiftGId(Integer gid) {
		int index =giftDao.deleteByGiftGId(gid); 
		return index;
	}

	@Override
	public Integer insertGift(Gift gift) {
		int index=giftDao.insertGift(gift);
		return index;
	}

	@Override
	public Integer countByGift() {
		int count=giftDao.countByGift();
		return count;
	}

	@Override
	public int updateGiftGid(Gift gift) {
		int value=giftDao.updateGiftGid(gift);
		return value;
	}

	@Override
	public int updateGiftCount(Gift gift) {
		int valueof=giftDao.updateGiftCount(gift);
		return valueof;
	}

}
