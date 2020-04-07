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
	private String id;
	@Column
	private String pw;
	@Column
	private String name;

	public int getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	@Builder
	public UserModel(String _id, String _pw, String _name){
		this.id = _id;
		this.pw = _pw;
		this.name = _name;
	}

	public String getName() {
		return name;
	}
}
