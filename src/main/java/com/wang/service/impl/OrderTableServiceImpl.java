package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.pojo.OrderTable;
import com.wang.dao.OrderTableDao;
import com.wang.service.OrderTableService;
@Component
public class OrderTableServiceImpl implements OrderTableService{
	@Autowired
	private OrderTableDao orderTableDao;
	
	@Override
	public OrderTable selectOrderTablOneUser(Integer gid) {
		// TODO Auto-generated method stub
		return orderTableDao.selectOrderTablOneUser(gid);
	}

	@Override
	public List<OrderTable> selectAllOrderTablList() {
		// TODO Auto-generated method stub
		return orderTableDao.selectAllOrderTablList();
	}

	@Override
	public OrderTable selectByOrderTablGId(Integer gid) {
		// TODO Auto-generated method stub
		return orderTableDao.selectByOrderTablGId(gid);
	}

	@Override
	public Integer deleteByOrderTablGId(Integer gid) {
		// TODO Auto-generated method stub
		return orderTableDao.deleteByOrderTablGId(gid);
	}

	@Override
	public Integer insertOrderTabl(OrderTable orderTable) {
		// TODO Auto-generated method stub
		return orderTableDao.insertOrderTabl(orderTable);
	}

	@Override
	public Integer countByOrderTable() {
		// TODO Auto-generated method stub
		return orderTableDao.countByOrderTable();
	}

	@Override
	public int updateOrderTableuid(OrderTable OrderTable) {
		// TODO Auto-generated method stub
		return orderTableDao.updateOrderTableuid(OrderTable);
	}

	@Override
	public int updateOrderTableCount(OrderTable OrderTable) {
		// TODO Auto-generated method stub
		return orderTableDao.updateOrderTableCount(OrderTable);
	}

	@Override
	public OrderTable selectByOrderTableFromContentname(String contentname) {
		// TODO Auto-generated method stub
		return orderTableDao.selectByOrderTableFromContentname(contentname);
	}

	@Override
	public OrderTable selectByOrderUId(Integer uid) {
		// TODO Auto-generated method stub
		return orderTableDao.selectByOrderUId(uid);
	}

}
