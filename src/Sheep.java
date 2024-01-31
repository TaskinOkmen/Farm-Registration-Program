//This Class creates a template for Sheep Object
//TAŞKIN ÖKMEN 150122019

public class Sheep extends Mammal {
	private static int count = 0;
	
	//Constructor create a Sheep with given parameters
	public Sheep(String name, int age) {
		super(name, age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
		++count;
	}
	
	@Override
	public void sayGreeting() {
		System.out.println("Four legs good, two legs better!");
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void decrementCount() {
		--count;
	}	
}
