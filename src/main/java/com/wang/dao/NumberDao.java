package com.wang.dao;

import java.util.List;

import com.wang.pojo.Number;

public interface NumberDao {
	
	public List<Number>selectAllNumberList();
	
	public Number selectByNumberId(Integer id);
	
	public Integer deleteNumberId(Integer id);
	
 
	public Integer deleteNumberIdSAll(String []id);
	
	public Integer insertNumber(Number number);
	
	public Integer countNumber();
	
	public Integer updateNumberCount(Number number);
	
}
