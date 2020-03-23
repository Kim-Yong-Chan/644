package com.example.demo.controller;

import com.example.demo.model.Request.UserCreateRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User readUser(@PathVariable long id){
        userService.readUser(id);
    }

   // @PostMapping("/user/create") 같은거임
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public User createUser(@RequestBody UserCreateRequest userCreateRequest){
        User user = userService.createUser(userCreateRequest.getName(), userCreateRequest.getPhone());

        return user;
    }
}
