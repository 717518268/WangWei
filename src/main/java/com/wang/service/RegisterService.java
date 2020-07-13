package com.wang.service;

import com.wang.pojo.Register;



 
import java.util.List;
 

public interface RegisterService {
	
	 
	public List<Register> selectRegisterListRanking();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Register selectByPrimaryKey(Integer id);
	 
	/**
	 * 传一个点赞数进来
	 * @param register
	 * @return
	 */
	public Integer updateRegisterpPraiseCount(Register register);
	
}