package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Backenduser;
import com.entity.Datadictionary;

public interface BackendmsService {
	//验证登录
	public Backenduser dologin(String userCode,String userPassword);
	
	//查询条件和分页
	public List<Appinfo> backlist(@Param("softwareName")String softwareName,
						@Param("flatformId")int flatformId,
						@Param("categoryLevel1")int categoryLevel1,
						@Param("categoryLevel2")int categoryLevel2,
						@Param("categoryLevel3")int categoryLevel3,
						@Param("pageindex")int pageindex,
						@Param("pagesize")int pagesize);
	//总数量
	public int Count();
	
	//平台
	public List<Datadictionary> selectpt();
	
	//一级菜单查询
	public List<Appcategory> selectcd();
	
	//二级菜单
	public List<Appcategory> selectecd(int id);
	
	//通过ID查询appinfo
	public Appinfo selectID(int aid);
	
	//通过ID查询category
	public  Appversion selectversion(int id);
	
	//审核
	public int checksave(Appinfo appinfo);
}
