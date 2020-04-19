package com.teamViewer.userServer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseModel {
	String userId;
	String name;

	public LoginResponseModel(UserModel users) {
		userId = users.getUserId();
		name = users.getName();
	}
}
