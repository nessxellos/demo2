package com.example.demo2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo2.model.JpaMember;
import com.example.demo2.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 자동 생성 Autowired랑 같은 역할
public class MemberService {
	// RequiredArgsConstructor을 쓰기 위해 final로 생성해야 됨
	private final MemberRepository memberRepository;
	
	// 추가
	public void save(JpaMember member) { 
		// 함수는 insert가 아닌 save로 해야 됨.
		memberRepository.save(member);
	}
	
	// 전체보기
	public List<JpaMember> list(){
		
		return memberRepository.findAll();
	}
	
	//페이징 전체보기
	public Page<JpaMember> list(Pageable pageable){
		return memberRepository.findAll(pageable);
	}
	
	
	//상세정보보기
	public JpaMember detail(Long id) {
//		return memberRepository.findById(id).get();	
		return memberRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("상세보기 실패");
				});
	}
	
	//삭제하기
	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	// 수정하기
	@Transactional
	public void update(JpaMember member) {
		JpaMember m = memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setPassword(member.getPassword());
	}
	
}
