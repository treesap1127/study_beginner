package kr.ac.kopo.smartshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.kopo.smartshop.model.Member;
import kr.ac.kopo.smartshop.service.MemberService;

@Controller// 웹 요청과 응답을 처리함
public class RootController {
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("/")
	public String index() {//   /index 파일을 찾게 만듬
		
		return "index"; //값을 index로 보냄
	}
	@GetMapping("/login")
	public String login() {//   /index 파일을 찾게 만듬
		return "login"; //값을 index로 보냄
	}
	@PostMapping("/login")
	public String login(Member member,HttpSession session) {//   /index 파일을 찾게 만듬
		if(memberservice.login(member)) {
			session.setAttribute("member", member);
			return "redirect:.";
		}
		
		return "redirect:/login"; //값을 index로 보냄
	}
	@GetMapping("/signup")
	public String signup() {//   /index 파일을 찾게 만듬
		return "signup"; //값을 index로 보냄
	}

	@PostMapping("/signup")
	public String signup(Member member,RedirectAttributes ra) {
		memberservice.add(member);
		
		ra.addFlashAttribute("msg", "회원가입이 완료 되었습니다");
		// add속성은 모델으로 받아야함 플래시는 세션에 담김 리다이렉션 하기전에 세션에 값 넣어서 보내줌.-index에서 읽기 가능
		
		return "redirect:.";
	}

	@ResponseBody
	@GetMapping("/checkId")
	public String checkId(String id) {
		try{Thread.sleep(1*1000);}
		catch(InterruptedException e) { e.printStackTrace();}
		
		if(memberservice.checkId(id))
			return "OK";
		else return "FAIL";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:.";
	}
}
