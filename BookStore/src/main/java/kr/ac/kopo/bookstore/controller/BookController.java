package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService service;
	
	final String path = "book/";
	@GetMapping("/list")
	public String list(Model model) {//모댈애 들어가는것만으로도 관례로 view로 넘어간다는 관례를 작성했다?
		
		List<Book> list = service.list();
		model.addAttribute("list", list);
		
		return path+"list";
	}
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	@PostMapping("/add")
	public String add(Book item) {
		service.add(item);
		return "redirect:list";
	}
	@GetMapping("/update/{bookid}")
	public String update(@PathVariable int bookid,Model model) {
		Book item =service.item(bookid);
		model.addAttribute("item",item);
		
		return path+"update";
	}
	@PostMapping("/update/{bookid}")
	public String update(@PathVariable int bookid,Book item) {
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{bookid}")
	public String delete(@PathVariable int bookid) {
		service.delete(bookid);
		
		return "redirect:../list";
	}
}