package com.wang.service;

 
import java.util.List;

import com.wang.pojo.Gift;
import com.wang.pojo.OrderTable;

 



public interface  OrderTableService{
     
	public OrderTable selectByOrderUId(Integer uid);
	
	public OrderTable selectByOrderTableFromContentname(String contentname);

	/**
	 * 根据gid一对一查询gift和user两张表
	 * @param gid
	 * @return
	 */
	public OrderTable selectOrderTablOneUser(Integer gid );
	
	/**
	 * 展示所有的礼物
	 * @return
	 */
	public List<OrderTable> selectAllOrderTablList();
	/**
	 * 根据gid查询
	 * @param gid
	 * @return
	 */
	public OrderTable selectByOrderTablGId(Integer gid);
	
	/**
	 * 根据gid删除
	 * @param gid
	 * @return
	 */
	public Integer deleteByOrderTablGId(Integer gid);
	
	/**
	 * 添加礼物
	 * @param gift
	 * @return
	 */
	public Integer insertOrderTabl(OrderTable orderTable);
	/**
	 * 查礼物总数
	 * @return
	 */
	public Integer countByOrderTable();
	
	/**
	 * 根据gid修改uid
	 * 将此礼物的外键uid，设置给对应的用户uid
	 * @param gift
	 * @return
	 */
	public int updateOrderTableuid(OrderTable OrderTable);
	
	/**
	 * 根据gid修改库存，库存最后不要大于1
	 * @param gift
	 * @return
	 */
	public int updateOrderTableCount(OrderTable OrderTable);
	
}