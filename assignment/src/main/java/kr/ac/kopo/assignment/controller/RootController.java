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

import kr.ac.kopo.assignment.model.Memeber;
import kr.ac.kopo.assignment.service.MemberService;
import kr.ac.kopo.assignment.util.Search;

@Controller
public class RootController {
	@Autowired
	MemberService service;
	final String path="table/";
	@RequestMapping("/")
	public String root(Model model,Search search) {
		List<Memeber> list=service.list(search);
		model.addAttribute("list", list);
		return "index";
	}
	@GetMapping("/list")
	public String list(Search search,Model model) {
		List<Memeber> list=service.list(search);
		model.addAttribute("list", list);
		return path+"list";
	}
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	@PostMapping("/add")
	public String add(Memeber item) {
		service.add(item);
		return "redirect:list";
	}
	@GetMapping("/update/{num}")
	public String update(@PathVariable int num,Model model) {
		Memeber item =service.item(num);
		model.addAttribute("item",item);
		
		return path+"update";
	}
	@PostMapping("/update/{num}")
	public String update(@PathVariable int num,Memeber item) {
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
	public Memeber order(@RequestBody Memeber order) {
		service.order(order);
		return order;
	}
	
}
