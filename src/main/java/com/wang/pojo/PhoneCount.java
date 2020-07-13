package com.wang.pojo;

import java.io.Serializable;

/**
 * 统计手机号次数
 * @author Administrator
 *
 */
public class PhoneCount implements Serializable{
	private Integer pid;
	private String phone;
	private Integer count;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PhoneCount [pid=" + pid + ", phone=" + phone + ", count=" + count + "]";
	}
	public PhoneCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhoneCount(String phone, Integer count) {
		super();
		this.phone = phone;
		this.count = count;
	}
	
	
	
	
}
