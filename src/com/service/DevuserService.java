package com.service;

import org.apache.ibatis.annotations.Param;

import com.entity.Devuser;

public interface DevuserService {
	//��¼
	public Devuser login(String devCode,String devPassword);
}
