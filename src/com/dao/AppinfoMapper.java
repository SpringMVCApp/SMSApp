package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;

public interface AppinfoMapper {
	//查询条件和分页
	public List<Appinfo> selectAll(@Param("softwareName")String softwareName,
			@Param("status")int status,
			@Param("flatformId")int flatformId,
			@Param("categoryLevel1")int categoryLevel1,
			@Param("categoryLevel2")int categoryLevel2,
			@Param("categoryLevel3")int categoryLevel3,
			@Param("pageindex")int pageindex,
			@Param("pagesize")int pagesize);

	//总数量
	public int Count();
	
	//状态
	public List<Datadictionary> selectdictionary();
	
	//平台
	public List<Datadictionary> selectpt();
	
	//一级菜单查询
	public List<Appcategory> selectcd();
	
	//二级菜单
	public List<Appcategory> selectecd(@Param("id")int id);
	
	//历史版本列表
	public List<Appversion> selectversion(@Param("id")int id);
	
	//新增版本列表
	public int addversioninfo(Appversion appversion);
	
	//最新版本
	public int updateversionId(@Param("vid")int vid,@Param("aid")int aid);
	
	//查询版本ID
	public Appversion selectversionID(@Param("appId")int appId,@Param("versionNo")String versionNo);
	
}
