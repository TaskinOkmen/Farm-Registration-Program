//This Class creates a template for Animal Object
//TAŞKIN ÖKMEN 150122019

public class Animal {
	private String name;
	private int legNumber;
	private int age;
	private int pregnancyPerYear;
	private int numberOfOffsprings;
	
	//Constructor create an Animal with given parameters
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//Print greeting
	public void sayGreeting() {
		System.out.println("Have nothing to say!");
	}
	
	public void reproduce() {
		System.out.println("None of your business!!");
	}
	
	@Override
	public String toString() {
		return "My name is " + name + "!\nI am " + age + " years old!\nI have " + legNumber + " legs!";
	}
	
	//Getter and Setter Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegNumber() {
		return legNumber;
	}

	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPregnancyPerYear() {
		return pregnancyPerYear;
	}

	public void setPregnancyPerYear(int pregnancyPerYear) {
		this.pregnancyPerYear = pregnancyPerYear;
	}

	public int getNumberOfOffsprings() {
		return numberOfOffsprings;
	}

	public void setNumberOfOffsprings(int numberOfOffsprings) {
		this.numberOfOffsprings = numberOfOffsprings;
	}
}
