package kr.ac.kopo.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	final String path = "customer/";
	@GetMapping("/list")
	public String list() {
		return path+"list";
	}
}
