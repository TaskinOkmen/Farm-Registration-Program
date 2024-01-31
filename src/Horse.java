//This Class creates a template for Horse Object
//TAŞKIN ÖKMEN 150122019

public class Horse extends Mammal {
	private static int count = 0;
	
	//Constructor create a Horse with given parameters
	public Horse(String name, int age) {
		super(name, age);
		setLegNumber(4);
		setNumberOfOffsprings(1);
		setPregnancyPerYear(1);
		++count;
	}
	
	@Override
	public void sayGreeting() {
		System.out.println("I will work harder!");
	}
	
	public static int getCount() {
		return count;
	}

	public static void decrementCount() {
		--count;
	}
}
