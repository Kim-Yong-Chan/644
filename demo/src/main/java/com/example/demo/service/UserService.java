package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String phone){
        User user = new User(0, name, phone);

        return user;
    }

    public User modifyUser(long id, String name, String phone){
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(()-> new ExpressionException("error"));
        return null;
    }

    public User readUser(long id) {
        return
    }
}
