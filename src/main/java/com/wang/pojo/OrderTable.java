package com.wang.pojo;

import java.io.Serializable;
import java.util.List;
 
/*
 * 礼物表
 */
public class OrderTable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5286980151070400739L;

	private Integer gid;//主键
	
	private String title;
	private String contentname;//名字信息
	
	private String image;
	 
	private Integer count;//数量
 
	private String time;//时间
	private Integer uid;//对应uid
	
	//对应
	private User user;
	
	private List<User> users;

	@Override
	public String toString() {
		return "Gift [gid=" + gid + ", title=" + title + ", contentname=" + contentname + ", image=" + image
				+ ", count=" + count + ", time=" + time + ", uid=" + uid + ", user=" + user + ", users=" + users + "]";
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentname() {
		return contentname;
	}

	public void setContentname(String contentname) {
		this.contentname = contentname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrderTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
