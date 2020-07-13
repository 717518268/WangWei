package com.wang.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表
 * @author Administrator
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3681354364239232139L;
	
	private Integer uid;//主键id
	private String phone;//电话
	private String name;//姓名
	private Integer gid;//对应gid
	//用户对应礼物表
	private Gift gift;
	
	private OrderTable orderTable;
	private List<Gift> gifts;
	 
	@Override
	public String toString() {
		return "User [uid=" + uid + ", phone=" + phone + ", name=" + name + ", gid=" + gid + ", gift=" + gift
				+ ", orderTable=" + orderTable + ", gifts=" + gifts + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}
	public List<Gift> getGifts() {
		return gifts;
	}
	public void setGifts(List<Gift> gifts) {
		this.gifts = gifts;
	}
	public OrderTable getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}
	
	
	
}
