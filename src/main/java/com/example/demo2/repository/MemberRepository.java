package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.model.JpaMember;

public interface MemberRepository 
	extends JpaRepository<JpaMember, Long> { // Entity와 기본키의 타입
	
	
}
