package com.teamViewer.userServer.controllers;

import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamViewer.userServer.model.UserModel;
import com.teamViewer.userServer.services.UserService;

@RequestMapping("/users")
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void addUsers(@RequestBody UserModel usermodel){
		System.out.println("update");
		userService.addUser(usermodel);
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public UserModel findById(@PathVariable("id") String id){
		Optional<UserModel> optional = userService.findById(id);
		if(optional.isPresent()) {

			UserModel users =  optional.get();

			System.out.println("find by id " + users.getName());
			return users;
		}
		return null;
	}

	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
	public UserModel findByName(@PathVariable("name") String name){
		Optional<UserModel> optional = userService.findByName(name);
		if(optional.isPresent()) {

			UserModel users =  optional.get();

			System.out.println("find by Name id"+"["+users.getId()+"]"+"pw"+"["+users.getPw()+"]");
			return users;
		}
		System.out.println("find by Name null");
		return null;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		System.out.println("test");
		return "test result";
	}

}
