package com.teamviewer.WebServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.teamviewer.WebServer.client.LoginClient;
import com.teamviewer.WebServer.model.LoginRequestModel;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class pageController {

	@Autowired
	private LoginClient loginClient;

	@RequestMapping("/login")
	public String loginPage(){
		log.debug("login");
		return "login.html";
	}
	@RequestMapping("/main")
	public String mainPage(){
		log.debug("main");
		return "mainPage.html";
	}

	/**/
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request){
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		log.debug("login.do");
		System.out.println("login");
		try{
			loginClient.login(new LoginRequestModel(userId, userPw));
		}catch (Exception e){
			log.debug(e.toString());
			System.out.println(e.toString());
			return "redirect:login";
		}
		return "redirect:main";
	}
}
