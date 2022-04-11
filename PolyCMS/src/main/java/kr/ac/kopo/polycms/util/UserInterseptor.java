package kr.ac.kopo.polycms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import kr.ac.kopo.polycms.model.Member;

public class UserInterseptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member =(Member) session.getAttribute("member");
		if(member!=null) {
			System.out.println("UserInterseptor : True");
			return true;
		}
		
		String query=request.getQueryString();
		session.setAttribute("target", request.getRequestURI()+(query != null ? "?" + query:"" ));

//		URL url = new URL(request.getRequestURL().toString(););
//		String query=url.getQuery();
//		String target =url.getPath()+(query!=null?query:"");
//		이거 쿼리 스트링 못가져옴 그냥 request가 먹히넹.. ㅎㅎ
		
		
		

		System.out.println("UserInterseptor : False");
		response.sendRedirect("/login");
		return false;
	}
	
}
