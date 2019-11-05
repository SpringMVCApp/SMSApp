package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Backenduser;
import com.service.BackendmsService;

@Controller
@RequestMapping(value="/manager")
public class Managercontroller {
	@Resource
	private BackendmsService BackendmsService;
	
	
	@RequestMapping(value="/login")
	public String back() {
		return "backendlogin";
	}

	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam("userCode")String userCode,@RequestParam("userPassword")String userPassword,HttpSession session) {
		Backenduser backenduser=BackendmsService.dologin(userCode, userPassword);
		if(backenduser!=null) {
			System.out.println(backenduser);
			session.setAttribute("userSession", backenduser);
			return "backend/main";
		}else {
			throw new RuntimeException();
		}
	}
	
	
	@ExceptionHandler(value={RuntimeException.class})
	public String handlerException(){
		return "403";
	}
}
