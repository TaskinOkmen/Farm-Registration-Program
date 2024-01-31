//This Class creates a template for Mammal Object
//TAŞKIN ÖKMEN 150122019

public class Mammal extends Animal {
	//Constructor create a Mammal with given parameters
	public Mammal(String name, int age) {
		super(name, age);
	}
	
	public void walk() {
		System.out.println("I can walk to the far away lands!");
	}
	
	@Override
	public void reproduce() {
		System.out.println("I give birth!");
	}
	
	public void herbivore() {
		System.out.println("I eat plants only!");
	}
} 
