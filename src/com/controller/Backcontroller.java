package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Datadictionary;
import com.entity.Page;
import com.service.BackendmsService;

@Controller
@RequestMapping(value="/back")
public class Backcontroller {
	@Resource
	private BackendmsService BackendmsService;
    @RequestMapping(value="/applist")
    public String applist(@RequestParam(value="querySoftwareName",required=false)String querySoftwareName,
			@RequestParam(value="queryFlatformId",required=false)String queryFlatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)String queryCategoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)String queryCategoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)String queryCategoryLevel3,
			@RequestParam(value="pageindex",required=false)String pageindex,
			Model model) {
    	Page page=new Page();
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
		page.setTotalCount(BackendmsService.Count());
		//计算当前页码
		int dqpage=(currentPageNo-1)*page.getPageSize();
		List<Appinfo>list=BackendmsService.backlist(querySoftwareName, FlatformId, CategoryLevel1, CategoryLevel2, CategoryLevel3, dqpage, page.getPageSize());
		//平台
		List<Datadictionary>list3=BackendmsService.selectpt();
		//一级菜单
		List<Appcategory>list4=BackendmsService.selectcd();
		//集合
		model.addAttribute("appInfoList", list);
		model.addAttribute("flatFormList", list3);
		model.addAttribute("categoryLevel1List", list4);
		//页码查询
		page.setCurrentPageNo(currentPageNo);
		model.addAttribute("pages", page);
		return "backend/applist";
    }
    
    @RequestMapping(value="/categorylevellist",produces= {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object categorylevellist(@RequestParam("pid")String pid) {
    	int id=Integer.parseInt(pid);
    	List<Appcategory>list=BackendmsService.selectecd(id);
    	String data="";
    	if(list!=null) {
    		data=JSON.toJSONString(list);
    	}
    	return data;
    	
    }
}
