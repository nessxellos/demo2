package com.example.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JpaMember { //대문자는 _소문자로 변경됨 =>jpa_member로 생성
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	//id를 기본키, 자동 증가 = 시퀀스
	private Long id;
	private String name;
	private String password;
	private String email;
	private String memo;
	@Column(name="address") // mySql의 컬럼이름은 address로 생성
	private String addr;
	
	
	
}
