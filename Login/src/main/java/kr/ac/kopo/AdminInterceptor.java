package kr.ac.kopo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AdminInterceptor");

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member != null && member.getId().equals("admin")) {
			return true;
		}
		response.sendRedirect("/login");
		return false;
	}

}
