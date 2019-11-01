package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;

public interface AppinfoService {
	//查询条件和分页
	public List<Appinfo> selectAll(String softwareName,int status,int flatformId,int categoryLevel1,int categoryLevel2,int categoryLevel3,int pageindex,int pagesize);
	
	//总数量
	public int Count();
	
	//状态
	public List<Datadictionary> selectdictionary();
	
	//平台
	public List<Datadictionary> selectpt();
	
	//一级菜单查询
	public List<Appcategory> selectcd();
	
	//二级菜单
	public List<Appcategory> selectecd(int id);
	
	//历史版本列表
	public List<Appversion> selectversion(int id);
	
	//新增版本列表
	public int addversioninfo(Appversion appversion);
	
	//最新版本
	public int updateversionId(int vid,int aid);
	
	//查询版本ID
	public Appversion selectversionID(int appId,String versionNo);
}
