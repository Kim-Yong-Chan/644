package com.teamViewer.userServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*lombok을 통한 getter, setter*/
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class UserModel {
	/*@Id를 이용하여 기본 키 설정*/
	@Id
	@GeneratedValue // Auto IncId Generator
	private int num;
	/*@Column을 이용하여 데이터 베이스 컬럼 설정*/
	@Column
	private String userId;
	@Column
	private String userPw;
	@Column
	private String name;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}

	@Builder
	public UserModel(String _userId, String _userPw, String _name){
		this.userId = _userId;
		this.userPw = _userPw;
		this.name = _name;
	}

	public String getName() {
		return name;
	}
}
