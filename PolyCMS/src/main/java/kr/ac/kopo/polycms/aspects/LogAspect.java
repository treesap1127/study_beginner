package kr.ac.kopo.polycms.aspects;
 
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.ac.kopo.polycms.model.Article;
import kr.ac.kopo.polycms.model.Member;
import kr.ac.kopo.polycms.service.LogService;

@Aspect
@Component
public class LogAspect {
   @Autowired
   LogService service;
	
   @AfterReturning(pointcut="@annotation(PointcutLogin) && args(member)", returning = "result")
   public void LogLogin(JoinPoint joinPoint,Member member, boolean result) {
      System.out.println("Login:" + member.getId() + "->" + result);
      
      service.login(member,result);
   }
   
   @Before("execution(* kr.ac..ArticleService*.add(..))&& args(item)")
   public void LogArticleAdd(Article item) {
	   System.out.println("새글쓰기"+item.getSubject());
   }
   
}
 