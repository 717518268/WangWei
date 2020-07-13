package com.wang.pojo;

import java.io.Serializable;

public class RootUser implements Serializable{
	private Integer id;
	private String username;
	private String atckass;//状态
	private Integer messagecount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAtckass() {
		return atckass;
	}
	public void setAtckass(String atckass) {
		this.atckass = atckass;
	}
	@Override
	public String toString() {
		return "RootUser [id=" + id + ", username=" + username + ", atckass=" + atckass + "messagecount"+messagecount+"]";
	}
	public Integer getMessagecount() {
		return messagecount;
	}
	public void setMessagecount(Integer messagecount) {
		this.messagecount = messagecount;
	}
	
	
	
	
}
