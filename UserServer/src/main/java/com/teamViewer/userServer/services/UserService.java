package com.teamViewer.userServer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamViewer.userServer.model.UserModel;
import com.teamViewer.userServer.repository.UserRepositoy;

/*Service의 역할은 Dao가 DB에서 받아온 데이터를 전달받아 가공하는 것*/
@Service
public class UserService {
	@Autowired
	private UserRepositoy userRepositoy;

	public void addUser(UserModel userModel){
		userRepositoy.save(userModel);
	}

	public Optional<UserModel> findByUserId(String id){
		return userRepositoy.findByUserId(id);
	}

	public Optional<UserModel> findByName(String name){
		return userRepositoy.findByName(name);
	}
}
