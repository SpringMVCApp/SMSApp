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
			session.setAttribute("userSession", backenduser);
			return "backend/main";
		}else {
			throw new RuntimeException();
		}
	}
	
	//返回主页
	@RequestMapping(value="/main")
	public String main() {
		return "backend/main";
	}
	
	//退出返回登录页面
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userSession");
		return "index";
	}
	
	
	@ExceptionHandler(value={RuntimeException.class})
	public String handlerException(){
		return "403";
	}
}
