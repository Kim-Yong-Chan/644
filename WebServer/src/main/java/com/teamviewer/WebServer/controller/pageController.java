package com.teamviewer.WebServer.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamviewer.WebServer.client.BoardClient;
import com.teamviewer.WebServer.client.LoginClient;
import com.teamviewer.WebServer.client.RoomClient;
import com.teamviewer.WebServer.model.LoginRequestModel;
import com.teamviewer.WebServer.model.LoginResponseModel;
import com.teamviewer.WebServer.model.RoomModel;
import com.teamviewer.WebServer.session.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class pageController {

	@Autowired
	private LoginClient loginClient;
	@Autowired
	private RoomClient roomClient;
	@Autowired
	private BoardClient boardClient;

	@Resource
	private UserInfo userInfo;

	@RequestMapping("/login")
	public String loginPage(){
		log.debug("login");
		return "login.html";
	}

	/*model을 이용하여 thymeleaf 사용*/
	@RequestMapping("/main")
	public String mainPage(Model model){
		log.debug("main");
		if(userInfo.getName() == null || userInfo.getUserId() == null) return "redirect:login";
		model.addAttribute("name", userInfo.getName());
		model.addAttribute("userId", userInfo.getUserId());
		model.addAttribute("roomList", userInfo.getRoomModelList());
		model.addAttribute("postList", userInfo.getBoardList());
		model.addAttribute("activatedRoom", (userInfo.getActivatedRoom() == null ) ? 0 : userInfo.getActivatedRoom());
		return "cootoo.html";
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
			getRoomList();
		}catch (Exception e){
			log.debug(e.toString());
			return "redirect:login";
		}
		return "redirect:main";
	}

	@RequestMapping(value = "/RoomList", method = RequestMethod.GET)
	public String getRoomList() throws Exception {
		userInfo.setRoomModelList(roomClient.roomListById(userInfo.getUserId()));
		return "redirect:/main";
	}
	@RequestMapping(value = "/PostsList/{roomId}", method = RequestMethod.GET)
	public String getPostList(@PathVariable("roomId") Integer roomId){
		userInfo.setBoardList(boardClient.getBoardList(roomId));
		userInfo.setActivatedRoom(roomId);
		return "redirect:/main";
	}
}
