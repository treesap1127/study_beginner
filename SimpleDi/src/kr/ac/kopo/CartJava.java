package kr.ac.kopo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CartConfig.class);
		
		Cart cart=(Cart) ctx.getBean("cart");
		
		cart.run();
		
		ctx.close();
		
	}

}
