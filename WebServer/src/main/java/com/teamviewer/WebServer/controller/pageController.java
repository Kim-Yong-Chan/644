package com.teamviewer.WebServer.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamviewer.WebServer.client.LoginClient;
import com.teamviewer.WebServer.model.LoginRequestModel;
import com.teamviewer.WebServer.model.LoginResponseModel;
import com.teamviewer.WebServer.session.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class pageController {

	@Autowired
	private LoginClient loginClient;

	@Resource
	private UserInfo userInfo;

	@RequestMapping("/login")
	public String loginPage(){
		log.debug("login");
		return "login.html";
	}
	@RequestMapping("/main")
	public String mainPage(){
		log.debug("main");
		if(userInfo.getName() == null || userInfo.getUserId() == null) return "redirect:login";
		return "mainPage.html";
	}

	/**/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request){
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		log.debug("login.do");
		try{
			LoginResponseModel loginResponseModel = loginClient.login(new LoginRequestModel(userId, userPw));
			userInfo.setUserId(loginResponseModel.getUserId());
			userInfo.setName(loginResponseModel.getName());
		}catch (Exception e){
			log.debug(e.toString());
			return "redirect:login";
		}
		return "redirect:main";
	}
}
