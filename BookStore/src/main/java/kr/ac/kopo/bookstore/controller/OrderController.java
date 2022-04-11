package kr.ac.kopo.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	final String path = "order/";
	@GetMapping("/list")
	public String list() {
		return path+"list";
	}
}
