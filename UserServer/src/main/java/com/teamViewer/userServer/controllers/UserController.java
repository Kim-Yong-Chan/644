package com.teamViewer.userServer.controllers;

import java.util.IllegalFormatException;
import java.util.Optional;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teamViewer.userServer.exception.NoDataException;
import com.teamViewer.userServer.model.UserModel;
import com.teamViewer.userServer.services.UserService;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/users")
@RestController
@ControllerAdvice
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	UserModel users;

	/*issue#7 추측가능한 url 제거*/
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addUsers(@RequestBody UserModel usermodel){
		log.debug("update");
		userService.addUser(usermodel);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserModel findById(@PathVariable("id") String id) throws NoDataException {
			Optional<UserModel> optional = userService.findByUserId(id);
			/*issue#5 lambda식을 활용*/
			return optional.orElseThrow(NoDataException::new);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		/*issue#4 sysout 대신 log4j사용*/
		/*@slf4j로 log*/
		log.debug("test");
		return "test result";
	}

	/*Exception Handler*/
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = NoDataException.class)
	public String userErrorHandler(Exception e){
		/*issue#6  HTTP Status Code 활용*/
		return e.toString();
	}
}
