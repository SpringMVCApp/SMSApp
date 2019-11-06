package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BackendMapper;
import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Backenduser;
import com.entity.Datadictionary;
import com.service.BackendmsService;
@Service("backendservice")
public class BackendmsServiceimpl implements BackendmsService{
	@Resource
	private BackendMapper backendMapper;
	
	public Backenduser dologin(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		return backendMapper.dologin(userCode, userPassword);
	}

	//查询条件和分页
	public List<Appinfo> backlist(String softwareName, int flatformId, int categoryLevel1, int categoryLevel2,
			int categoryLevel3, int pageindex, int pagesize) {
		return backendMapper.backlist(softwareName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageindex, pagesize);
	}

	//总数量
	public int Count() {
		return backendMapper.Count();
	}

	//平台
	public List<Datadictionary> selectpt() {
		return backendMapper.selectpt();
	}

	//一级菜单查询
	public List<Appcategory> selectcd() {
		return backendMapper.selectcd();
	}

	//二级菜单
	public List<Appcategory> selectecd(int id) {
		return backendMapper.selectecd(id);
	}

	//通过ID查询appinfo
	public Appinfo selectID(int aid) {
		return backendMapper.selectID(aid);
	}

	//通过ID查询category
	public Appversion selectversion(int id) {
		return backendMapper.selectversion(id);
	}

	//审核
	public int checksave(Appinfo appinfo) {
		return backendMapper.checksave(appinfo);
	}

}
