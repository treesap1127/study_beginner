package kr.ac.kopo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cart {
	
	private Color color;
	private Wheel wheel;
	private Type type;
	
	
	public void run() {
		String run="[카트] ";
		if(color != null)
		run += color.run();
		
		if(wheel != null)
		run += wheel.run();
		
		if(type != null)
		run += type.run();
		
		System.out.println(run);
	}
	@Autowired
	public void setColor(Color color) {
		this.color=color;
		
	}
	@Autowired
	public void setWheel(Wheel wheel) {
		this.wheel=wheel;
		
	}
	@Autowired
	public void setType(Type type) {
		this.type=type;
		
	}

}
