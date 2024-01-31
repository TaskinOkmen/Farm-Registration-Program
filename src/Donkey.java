//This Class creates a template for Donkey Object
//TAŞKIN ÖKMEN 150122019

public class Donkey extends Mammal {
	private static int count = 0;
	
	//Constructor create a Donkey with given parameters
	public Donkey(String name, int age) {
		super(name, age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
		++count;
	}
	
	@Override
	public void sayGreeting() {
		System.out.println("Life will go on as it has always gone –that is, badly!");
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void decrementCount() {
		--count;
	}
}
