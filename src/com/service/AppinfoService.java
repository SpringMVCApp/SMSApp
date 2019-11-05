package com.service;

import java.util.Date;
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
	
	//按版本ID查询
	public Appversion versionID(int id);
	
	//修改版本
	public int versionUpdate(Appversion appversion);
	
	//按id查询appinfo
	public Appinfo selectAppinfoId(int id);
	
	//加载平台
	public List<Datadictionary> selectdata(String typeCode);
	
	//加載二级菜单
	public List<Appcategory> seleerjcd(String id);
	
	//修改App基本信息
	public int updateappinfo(Appinfo appinfo);
	
	//删除App信息
	public int deleteappinfo(int id);
	
	//新增App信息
	public int addAppinfo(Appinfo appinfo);
	
	//上下架
	public int sale(Appinfo appinfo);
}
