package com.wang.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 注册表
 * @author Administrator
 *
 */
public class Register implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1852175834224917503L;

	private Integer id;

    private String username;//用户名

    private String password;//密码
    
    
	private String myselfcontext;//个性签名

    private String email;//邮箱

    private String phone;//电话

    private String nickname;//昵称

    private String sex;//性别

    private String state;//状态
    
    private Integer praisecount;//点赞
    
    private String imgurl;//头像图片
    
    private String registerdata;	//注册时间
    
    private Integer commentCount;
    private Integer praiseCountmyslf;
    private Integer contentCount;
    
    private Integer number;//计算全部的点赞包括用户和文章的点赞
    
    
    private String percentage;//存百分比


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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMyselfcontext() {
		return myselfcontext;
	}


	public void setMyselfcontext(String myselfcontext) {
		this.myselfcontext = myselfcontext;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Integer getPraisecount() {
		return praisecount;
	}


	public void setPraisecount(Integer praisecount) {
		this.praisecount = praisecount;
	}


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public String getRegisterdata() {
		return registerdata;
	}


	public void setRegisterdata(String registerdata) {
		this.registerdata = registerdata;
	}


	public Integer getCommentCount() {
		return commentCount;
	}


	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}


	public Integer getPraiseCountmyslf() {
		return praiseCountmyslf;
	}


	public void setPraiseCountmyslf(Integer praiseCountmyslf) {
		this.praiseCountmyslf = praiseCountmyslf;
	}


	public Integer getContentCount() {
		return contentCount;
	}


	public void setContentCount(Integer contentCount) {
		this.contentCount = contentCount;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getPercentage() {
		return percentage;
	}


	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Register [id=" + id + ", username=" + username + ", password=" + password + ", myselfcontext="
				+ myselfcontext + ", email=" + email + ", phone=" + phone + ", nickname=" + nickname + ", sex=" + sex
				+ ", state=" + state + ", praisecount=" + praisecount + ", imgurl=" + imgurl + ", registerdata="
				+ registerdata + ", commentCount=" + commentCount + ", praiseCountmyslf=" + praiseCountmyslf
				+ ", contentCount=" + contentCount + ", number=" + number + ", percentage=" + percentage + "]";
	}
    
 
    
 
 
}