package com.dao;

import org.apache.ibatis.annotations.Param;

import com.entity.Devuser;

public interface DevuserMapper {
	//µÇÂ¼
	public Devuser login(@Param("devCode")String devCode,@Param("devPassword")String devPassword);

}
