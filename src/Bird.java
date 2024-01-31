//This Class creates a template for Bird Object
//TAŞKIN ÖKMEN 150122019

public class Bird extends Animal {
	//Constructor create a Bird with given parameters
	public Bird(String name, int age) {
		super(name, age);
	}
	
	public void fly() {
		System.out.println("I can fly to the endless skies!");
	}
	
	@Override
	public void reproduce() {
		System.out.println("I lay eggs!");
	}
	
	public void omnivore() {
		System.out.println("I can eat everything!");
	}
}
