package kr.ac.kopo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartJavaScan {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CartConfigScan.class);
		
		Cart cart=(Cart) ctx.getBean("cart");
		
		cart.run();
		
		ctx.close();
		
	}

}
