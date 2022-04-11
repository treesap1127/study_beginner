package kr.ac.kopo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Wheel {

	private String wheel;
	
	@Autowired
	public Wheel(@Qualifier("wheel_default") String wheel) {
		this.wheel=wheel;
		//수정자로 주입
	}
	public String run() {
		return wheel+" 타이어를 단 ";
		
	}

}
