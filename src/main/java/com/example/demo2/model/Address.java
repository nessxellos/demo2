package com.example.demo2.model;

import javax.persistence.Embeddable;

@Embeddable // 부분적 클래스
public class Address {
	private String zipcode;
	private String address1;
	private String address2;
}
