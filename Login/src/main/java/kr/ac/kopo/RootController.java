package kr.ac.kopo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {

		
		return "login";
	}
	@PostMapping("/login")
	public String login(Member member,HttpSession session) {
		if(member.login()) {
			System.out.println("로그인 됐습니다"+member);
			
			session.setAttribute("member", member);
			
			return "redirect:.";
		}
		System.out.println("로그인 실패:"+member);
		return "redirect:login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:.";
	}
	@RequestMapping("/book")
	public String book() {
		return "book";
	}
	@RequestMapping("/customer")
	public String customer() {
		return "customer";
	}
	@RequestMapping("/order")
	public String order() {
		return "order";
	}
	@RequestMapping("/order/info")
	public String info() {
		return "info";
	}
	
	
	
}
