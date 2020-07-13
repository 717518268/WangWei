package com.wang.pojo;

import java.io.Serializable;

/**
 * 统计计入活动页的人数
 * @author Administrator
 *
 */
public class Number implements Serializable{
	private Integer id;
	private Integer count;
	private String data;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Number() {
		super();
	}
	@Override
	public String toString() {
		return "Number [id=" + id + ", count=" + count + "]";
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
