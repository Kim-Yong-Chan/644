package com.teamViewer.userServer.controllers;

import java.util.IllegalFormatException;
import java.util.Optional;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamViewer.userServer.model.UserModel;
import com.teamViewer.userServer.services.UserService;

@RequestMapping("users")
@RestController
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	UserModel users;

	/*issue#7 추측가능한 url 제거*/
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addUsers(@RequestBody UserModel usermodel){
		System.out.println("update");
		userService.addUser(usermodel);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object findById(@PathVariable("id") String id){
		try {
			Optional<UserModel> optional = userService.findByUserId(id);

			/*issue#5 lambda식을 활용*/
			optional.ifPresent(s -> users = s);
			optional.orElseThrow(Exception::new);
			return users;
		}catch (Exception e) {

		}
		/*issue#6  HTTP Status Code 활용*/
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		/*issue#4 sysout 대신 log4j사용*/
		logger.debug("test");
		return "test result";
	}

}
