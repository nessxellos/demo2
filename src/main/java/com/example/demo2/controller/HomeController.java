package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo2.model.JpaMember;
import com.example.demo2.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//회원가입 화면
	@GetMapping("join")
	public String join() {
		return "insert";
	}
	
	//회원가입
	@PostMapping("join")
	public String join(JpaMember member) {
		memberService.save(member);
		return "redirect:list";
	}
	
	//회원 리스트 + 페이징
	@GetMapping("list")
	public String list(Model model,
			@PageableDefault(size = 3, sort = "id", 
							 direction = Sort.Direction.DESC) Pageable pageable
			) {
//		List<JpaMember> lists = memberService.list();
		System.out.println("pageable : " + pageable);
		Page<JpaMember> lists = memberService.list(pageable);
		model.addAttribute("lists", lists);
		return "list";
	}
	
	//회원정보 상세보기
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		
		return "detail";
	}
	
	//회원탈퇴
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		memberService.delete(id);
		return "redirect:/list";
	}
	
	//회원탈퇴(ajax)
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete1(@PathVariable Long id) {
		memberService.delete(id);
		return "success";
	}	
	
	//회원수정 화면
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		
		return "update";
	}
	
	//회원수정하기
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody JpaMember member) {
		memberService.update(member);
		return "success";	
	}
	
}
