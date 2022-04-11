package kr.ac.kopo;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//@Configuration
public class CartConfig {
	@Bean
	public Cart cart() {
		return new Cart();
	}
	
	@Bean
	public Color color() {
		return new Color("녹색");
	}
	@Bean
	public Type type() {
		return new Type("아반떼");
	}
	
	@Bean
	public Wheel wheel() {
		return new Wheel("네모난");
	}
}
