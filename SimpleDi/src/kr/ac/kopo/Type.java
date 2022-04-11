package kr.ac.kopo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Type {

	private String type;
	
	@Autowired
	public Type(@Qualifier("type_default") String type) {
		this.type=type;
		//수정자로 주입
	}
	public String run() {
		return type+"가 달린다.";
		
	}

}
