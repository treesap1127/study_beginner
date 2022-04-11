package kr.ac.kopo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Color {
	private String color;
	
	@Autowired
	public Color(@Qualifier("color_default") String color) {
		this.color=color;
		//수정자로 주입
	}

	public String run() {
		return color+"으로 도색 된 ";
	}
}

