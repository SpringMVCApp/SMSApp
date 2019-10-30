package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DevuserMapper;
import com.entity.Devuser;
import com.service.DevuserService;
@Service("Devuserservice")
public class DevuserServiceimpl implements DevuserService{
	@Resource
	private DevuserMapper  devuserMapper;
	//µÇÂ¼
	public Devuser login(String devCode, String devPassword) {
		return devuserMapper.login(devCode, devPassword);
	}

}
