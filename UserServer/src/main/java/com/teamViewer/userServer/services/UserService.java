package com.teamViewer.userServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamViewer.userServer.repository.UserRepositoy;

/*Service의 역할은 Dao가 DB에서 받아온 데이터를 전달받아 가공하는 것*/
@Service
public class UserService {
	@Autowired
	private UserRepositoy userRepositoy;
}
