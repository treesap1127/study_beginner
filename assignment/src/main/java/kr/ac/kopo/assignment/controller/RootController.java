package kr.ac.kopo.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.assignment.model.Member;
import kr.ac.kopo.assignment.service.MemberService;
import kr.ac.kopo.assignment.util.Search;

@Controller// 컨트롤러 선언
public class RootController {
	@Autowired
	MemberService service;
	final String path="table/";
	@RequestMapping("/")
	public String root(Model model,Search search) {
		List<Member> list=service.list(search);
		model.addAttribute("list", list);
		return "index";
	}
	@GetMapping("/list")
	public String list(Search search,Model model) {
		List<Member> list=service.list(search);
		model.addAttribute("list", list);
		return path+"list";
	}
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	@PostMapping("/add")
	public String add(Member item) {
		service.add(item);
		return "redirect:list";
	}
	@GetMapping("/update/{num}")
	public String update(@PathVariable int num,Model model) {
		Member item =service.item(num);
		model.addAttribute("item",item);
		
		return path+"update";
	}
	@PostMapping("/update/{num}")
	public String update(@PathVariable int num,Member item) {
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{num}")
	public String delete(@PathVariable int num) {
		service.delete(num);
		
		return "redirect:../list";
	}
	@ResponseBody
	@PostMapping("/order")
	public Member order(@RequestBody Member order) {
		service.order(order);
		return order;
	}
	@GetMapping("/dummy")
	public String dummy() {
		service.dummy();
		return "redirect:list";
	}
	
}
