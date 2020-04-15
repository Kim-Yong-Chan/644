package com.teamviewer.WebServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class pageController {
	@RequestMapping("/login")
	public String login(){
		log.debug("login");
		return "newsign.html";
	}
}
