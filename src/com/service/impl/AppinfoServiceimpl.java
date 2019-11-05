package com.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AppinfoMapper;
import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;
import com.service.AppinfoService;
@Service("Appinfoservice")
public class AppinfoServiceimpl implements AppinfoService{
	@Resource
	private AppinfoMapper appinfoMapper;
	//查询条件和分页
	public List<Appinfo> selectAll(String softwareName, int status, int flatformId, int categoryLevel1,
			int categoryLevel2, int categoryLevel3, int pageindex, int pagesize) {
		return appinfoMapper.selectAll(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageindex, pagesize);
	}
	//总数量
	public int Count() {
		return appinfoMapper.Count();
	}
	//状态
	public List<Datadictionary> selectdictionary() {
		return appinfoMapper.selectdictionary();
	}
	//平台
	public List<Datadictionary> selectpt() {
		return appinfoMapper.selectpt();
	}
	//一级菜单查询
	public List<Appcategory> selectcd() {
		return appinfoMapper.selectcd();
	}
	//二级菜单
	public List<Appcategory> selectecd(int id) {
		return appinfoMapper.selectecd(id);
	}
	//历史版本列表
	public List<Appversion> selectversion(int id) {
		return appinfoMapper.selectversion(id);
	}
	//新增版本列表
	public int addversioninfo(Appversion appversion) {
		return appinfoMapper.addversioninfo(appversion);
	}
	//最新版本
	public int updateversionId(int vid, int aid) {
		return appinfoMapper.updateversionId(vid, aid);
	}
	//查询版本ID
	public Appversion selectversionID(int appId,String versionNo) {
		return appinfoMapper.selectversionID(appId,versionNo);
	}
	//按版本ID查询
	public Appversion versionID(int id) {
		return appinfoMapper.versionID(id);
	}
	//修改版本
	public int versionUpdate(Appversion appversion) {
		return appinfoMapper.versionUpdate(appversion);
	}
	//按id查询appinfo
	public Appinfo selectAppinfoId(int id) {
		return appinfoMapper.selectAppinfoId(id);
	}
	//加载平台
	public List<Datadictionary> selectdata(String typeCode) {
		return appinfoMapper.selectdata(typeCode);
	}
	//加載二级菜单
	public List<Appcategory> seleerjcd(String id) {
		return appinfoMapper.seleerjcd(id);
	}
	
	//修改App基本信息
	public int updateappinfo(Appinfo appinfo) {
		return appinfoMapper.updateappinfo(appinfo);
	}
	//删除App信息
	public int deleteappinfo(int id) {
		return appinfoMapper.deleteappinfo(id);
	}
	//新增App信息
	public int addAppinfo(Appinfo appinfo) {
		return appinfoMapper.addAppinfo(appinfo);
	}
	//上下架
	public int sale(Appinfo appinfo) {
		return appinfoMapper.sale(appinfo);
	}

}
