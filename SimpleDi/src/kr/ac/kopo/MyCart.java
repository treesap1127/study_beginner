package kr.ac.kopo;

public class MyCart {

	public static void main(String[] args) {
		System.out.println("MyCart");
		
			Color color = new Color("빨간색");
			Wheel wheel = new Wheel("4계절용");
			Type type = new Type("아반떼");
			Cart cart = new Cart();
			
			cart.setColor(color);
			cart.setWheel(wheel);
			cart.setType(type);
			
			cart.run();
			
	}

}
