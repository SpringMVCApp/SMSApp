package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;
import com.entity.Devuser;
import com.entity.Page;
import com.service.AppinfoService;
import com.sun.java.swing.plaf.motif.resources.motif;
import com.sun.org.apache.xpath.internal.operations.And;

@Controller
@RequestMapping(value="/dev")
public class Devinfocontroller {
	@Resource
	private AppinfoService appinfoService;
	@RequestMapping(value="/applist")
	public String applist(@RequestParam(value="querySoftwareName",required=false)String querySoftwareName,
			@RequestParam(value="queryStatus",required=false)String queryStatus,
			@RequestParam(value="queryFlatformId",required=false)String queryFlatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)String queryCategoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)String queryCategoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)String queryCategoryLevel3,
			@RequestParam(value="pageindex",required=false)String pageindex,
			Model model) {
		Page page=new Page();
		int Status=0;
		if(queryStatus!=null && queryStatus !="") {	
			Status=Integer.parseInt(queryStatus);
		}
		int FlatformId=0;
		if(queryFlatformId!=null && queryFlatformId !="") {
			FlatformId=Integer.parseInt(queryFlatformId);
		}
		int CategoryLevel1=0;
		if(queryCategoryLevel1!=null && queryCategoryLevel1 !="") {
			CategoryLevel1=Integer.parseInt(queryCategoryLevel1);
		}
		
		int CategoryLevel2=0;
		if(queryCategoryLevel2!=null && queryCategoryLevel2 !="") {
			CategoryLevel2=Integer.parseInt(queryCategoryLevel2);
		}
		
		int CategoryLevel3=0;
		if(queryCategoryLevel3!=null && queryCategoryLevel3 !="") {
			CategoryLevel3=Integer.parseInt(queryCategoryLevel3);
		}
		
		//当前页码
		int currentPageNo=1;
		if(pageindex != null){
			currentPageNo = Integer.parseInt(pageindex);
		}
		//总数量
		page.setTotalCount(appinfoService.Count());
		//计算当前页码
		int dqpage=(currentPageNo-1)*page.getPageSize();
		List<Appinfo>list=appinfoService.selectAll(querySoftwareName, Status, FlatformId, CategoryLevel1, CategoryLevel2, CategoryLevel3, dqpage, page.getPageSize());
		//状态
		List<Datadictionary>list2=appinfoService.selectdictionary();
		//平台
		List<Datadictionary>list3=appinfoService.selectpt();
		//一级菜单
		List<Appcategory>list4=appinfoService.selectcd();
		//集合
		model.addAttribute("appInfoList", list);
		model.addAttribute("statusList", list2);
		model.addAttribute("flatFormList", list3);
		model.addAttribute("categoryLevel1List", list4);
		//页码查询
		page.setCurrentPageNo(currentPageNo);
		model.addAttribute("pages", page);
		return "developer/appinfolist";
	}
	
	//查询二级菜单
	@RequestMapping(value="/categorylevellist",produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Object categorylevellist(@RequestParam("pid")String pid) {
		int id=0;
		if(pid !=null && pid !="") {
			id=Integer.parseInt(pid);
		}
		List<Appcategory>list=appinfoService.selectecd(id);
		String count="";
		count=JSON.toJSONString(list);
		return count;
		
	}
	//历史版本列表
	@RequestMapping(value="/appversionadd")
	public String addVersion(@RequestParam("id")String id,Model model) {
		int vid=Integer.parseInt(id);
		List<Appversion>list=appinfoService.selectversion(vid);
		model.addAttribute("appVersionList", list);
		model.addAttribute("appId", vid);
		return "developer/appversionadd";
	}
	
	//新增APP版本信息
	@RequestMapping(value="/addversionsave")
	public String addversionsave(@ModelAttribute("appversion") Appversion appversion,HttpSession session,Model model) {	
		appversion.setCreatedBy(((Devuser)session.getAttribute("devUserSession")).getId());
		appversion.setCreationDate(new Date());
		int count =appinfoService.addversioninfo(appversion);
		Appversion appversion2=appinfoService.selectversionID(appversion.getAppId(), appversion.getVersionNo());
		if(count>0) {
			int num=appinfoService.updateversionId(appversion2.getId(),appversion.getAppId());
			if(num>0) {
				model.addAttribute("id", appversion.getAppId());
				return "redirect:/dev/appversionadd";
			}
			
		}
		return "developer/appversionadd";
	}
	
	//修改页码显示APP版本信息
	@RequestMapping(value="/versionmodify")
	public String appversionmodify(@RequestParam(value="vid")String vid,@RequestParam(value="aid",required=false)String aid,Model model) {
		int id=Integer.parseInt(aid);
		int Vid=Integer.parseInt(vid);
		Appversion appversion=appinfoService.versionID(Vid);
		model.addAttribute("appVersion", appversion);
		List<Appversion>list=appinfoService.selectversion(id);
		model.addAttribute("appVersionList", list);
		return "developer/appversionmodify";
	}
	
	//修改App版本
	@RequestMapping(value="/appversionmodifysave")
	public String appversionmodifysave(@ModelAttribute("appversion") Appversion appversion,HttpSession session,Model model) {
		appversion.setModifyDate(new Date());
		appversion.setModifyBy(((Devuser)session.getAttribute("devUserSession")).getId());
		int count=appinfoService.versionUpdate(appversion);
		if(count>0) {
			model.addAttribute("vid", appversion.getId());
			model.addAttribute("aid", appversion.getAppId());
			return "redirect:/dev/versionmodify";
		}
		return "developer/appversionmodify";
	}
	
	//显示App基本信息
	@RequestMapping(value="/appinfomodify")
	public String appinfomodify(@RequestParam("id")String id,Model model) {
		int aid=Integer.parseInt(id);
		Appinfo appinfo=appinfoService.selectAppinfoId(aid);
		model.addAttribute("appInfo", appinfo);
		return "developer/appinfomodify";
	}
	
	//加载平台
	@RequestMapping(value="/datadictionarylist",produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Object datadictionarylist(@RequestParam("tcode")String tcode) {
		String data="";
		List<Datadictionary>list=appinfoService.selectdata(tcode);
		if(list!=null) {
			data=JSON.toJSONString(list);
		}
		return data;
	}
	
	//加载二級菜單
		@RequestMapping(value="/levellist",produces= {"application/json;charset=UTF-8"})
		@ResponseBody
		public Object levellist(@RequestParam("pid")String pid) {
			String data="";
			List<Appcategory>list=appinfoService.seleerjcd(pid);
			if(list!=null) {
				data=JSON.toJSONString(list);
			}
			return data;
		}
		//修改App基本信息
		@RequestMapping(value="/appinfomodifysave")
		public String appinfomodifysave(@ModelAttribute("appinfo") Appinfo appinfo,HttpSession session,Model model) {
			appinfo.setModifyBy(((Devuser)session.getAttribute("devUserSession")).getId());
			appinfo.setModifyDate(new Date());
			int count=appinfoService.updateappinfo(appinfo);
			if(count>0) {
				return "redirect:/dev/applist";
			}
			Appinfo appinfo1=appinfoService.selectAppinfoId(appinfo.getId());
			model.addAttribute("appInfo", appinfo1);
			return "developer/appinfomodify";
		}
		//查看App信息
		@RequestMapping(value="/appview")
		public String appview(@RequestParam("aid")String aid,Model model) {
			int id=Integer.parseInt(aid);
			List<Appversion>list=appinfoService.selectversion(id);
			 Appinfo appinfo=appinfoService.selectAppinfoId(id);
			 model.addAttribute("appVersionList", list);
			 model.addAttribute("appInfo", appinfo);
			return "developer/appinfoview";
		}
		
		//删除app信息
		@RequestMapping(value="/delapp")
		@ResponseBody
		public Object delapp(@RequestParam("id")String id) {
			int aid=Integer.parseInt(id);
			String data="";
			int count=appinfoService.deleteappinfo(aid);
			if(id==null) {
				data="notexist";
			}else {
				if(count>0) {
					data="true";
				}else {
					data="false";
				}
			}
			String result=JSON.toJSONString(data);
			return result;
			
		}
		//跳转新增APP基础信息 
		@RequestMapping(value="/appinfoadd")
		public String appinfoadd() {
			return "developer/appinfoadd";
		}
		
		//新增APP基础信息 
		@RequestMapping(value="/appinfoaddsave")
		public String appinfoaddsave(@ModelAttribute("appinfo") Appinfo appinfo,Model model,HttpSession session) {
			appinfo.setDevId(((Devuser)session.getAttribute("devUserSession")).getId());
			appinfo.setCreationDate(new Date());
			appinfo.setCreatedBy(((Devuser)session.getAttribute("devUserSession")).getId());
			int count=appinfoService.addAppinfo(appinfo);
			if(count>0) {
				return "redirect:/dev/applist";
			}
			return "/dev/appinfoadd";
		}
		
		//上下架
		@RequestMapping(value="/sale",produces= {"application/json;charset=UTF-8"})
		@ResponseBody
		public Object appId(@RequestParam("appid")String appid,@RequestParam("zt")String zt) {
			HashMap<String, String>hashMap=new HashMap<String,String>();
			hashMap.put("errorCode", "0");
			int aid=Integer.parseInt(appid);
			Appinfo appinfo=new Appinfo();
			if(zt.equals("open")) {
				appinfo.setOnSaleDate(new Date());
				appinfo.setStatus(4);
				appinfo.setId(aid);
				int count=appinfoService.sale(appinfo);
				if(count>0) {
					hashMap.put("resultMsg", "success");
				}else {
					hashMap.put("resultMsg", "failed");
				}
				
			}else if (zt.equals("close")) {
				appinfo.setOffSaleDate(new Date());
				appinfo.setStatus(5);
				appinfo.setId(aid);
				int count=appinfoService.sale(appinfo);
				if(count>0) {
					hashMap.put("resultMsg", "success");
				}else {
					hashMap.put("resultMsg", "failed");
				}
				
			}
			return JSONArray.toJSONString(hashMap);
		}
}
