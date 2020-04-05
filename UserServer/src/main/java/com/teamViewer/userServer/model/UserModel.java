package com.teamViewer.userServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*lombok을 통한 getter, setter*/
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserModel {
	/*@Id를 이용하여 기본 키 설정*/
	@Id
	private int num;
	/*@Column을 이용하여 데이터 베이스 컬럼 설정*/
	@Column
	private String id;
	@Column
	private String pw;
	@Column
	private String name;
}
