package com.controller;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Devuser;
import com.service.DevuserService;

@Controller
@RequestMapping("/dev")
public class Usercontroller {
	@Resource
	private DevuserService DevuserService;
	@RequestMapping(value="/register")
	public String register() {
		return "devlogin";
	}
	
	@RequestMapping(value="/login")
	public String login(@RequestParam("devCode")String devCode,@RequestParam("devPassword")String devPassword,HttpSession session) {
		Devuser devuser=DevuserService.login(devCode, devPassword);
		if(devuser!=null) {
			session.setAttribute("devUserSession", devuser);
			return "developer/main";
		}else {
			throw new RuntimeException();
		}
		
	}
	
	@RequestMapping(value="/applist")
	public String applist() {
		return "developer/appinfolist";
	}
	
	@ExceptionHandler(value={RuntimeException.class})
	public String handlerException(){
		return "403";
	}
}
