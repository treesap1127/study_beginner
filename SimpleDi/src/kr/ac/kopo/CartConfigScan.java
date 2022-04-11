package kr.ac.kopo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="kr.ac.kopo")//컴포넌트 어노테이션 찾으면 빈에 만들어서 알아서 등록해줌
public class CartConfigScan {
	
	@Bean("color_default")
	public String color() {
		return "RED";
	}
	
	@Bean("wheel_default")
	public String wheel() {
		return "Circle";
	}
	
	@Bean("type_default")
	public String type() {
		return "BMW";
	}
	
}
