package com.example.demo2.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING) //Enum 클래스를 받는 애노테이션
	private Grade grade;
	@Embedded // Embeddable 을 받는 애노테이션
	private Address address;
	@OneToMany(mappedBy ="hotel") // 하나의 호텔에 여러개의 리뷰가 달림
	private List<Review> reviews;
	
}
