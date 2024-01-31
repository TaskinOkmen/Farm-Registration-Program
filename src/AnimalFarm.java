//This Class creates a template for AnimalFarm Object
//TAŞKIN ÖKMEN 150122019

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AnimalFarm {
	private ArrayList<Animal> animalList = new ArrayList<>();
	private ArrayList<String> animalNames = new ArrayList<>();
	private final int CAPACITY;
	private static int numberOfAnimals = 0;
	
	//Construct AnimalFarm with given capacity
	public AnimalFarm(int capacity) {
		CAPACITY = capacity;
	}
	
	//Getter method for numberOfAnimals
	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}
	
	//Add an animal to animalList if its name not in animalNames
	public boolean addAnimal(Animal animal) throws IllegalNameException {
		//Check for the name in animalNames
		if (animalNames.contains(animal.getName())) {
			
			//Decrement the count of the given Animal
			if (animal instanceof Chicken)
				Chicken.decrementCount();
			else if (animal instanceof Donkey)
				Donkey.decrementCount();
			else if (animal instanceof Horse)
				Horse.decrementCount();
			else if (animal instanceof Pig)
				Pig.decrementCount();
			else if (animal instanceof Raven)
				Raven.decrementCount();
			else if (animal instanceof Sheep)
				Sheep.decrementCount();			
			
			throw new IllegalNameException(animal.getName());
		}
		
		//Check for the capacity then add animal and its name
		if (numberOfAnimals < CAPACITY) {
			animalList.add(animal);
			animalNames.add(animal.getName());
			++numberOfAnimals;
			
			return true;
		}
		return false;
	}
	
	//Remove the animal from animalList and animalNames
	public boolean removeAnimal(String name) {
		if (animalNames.contains(name)) {
			//Get animals index
			int index = animalNames.indexOf(name);
			
			//Remove both from animalList and animalNames
			Animal animal = animalList.remove(index);
			animalNames.remove(index);
			--numberOfAnimals;
			
			//Decrement the count of the given Animal
			if (animal instanceof Chicken)
				Chicken.decrementCount();
			else if (animal instanceof Donkey)
				Donkey.decrementCount();
			else if (animal instanceof Horse)
				Horse.decrementCount();
			else if (animal instanceof Pig)
				Pig.decrementCount();
			else if (animal instanceof Raven)
				Raven.decrementCount();
			else if (animal instanceof Sheep)
				Sheep.decrementCount();
			
			return true;
		}
		return false;
	}
	
	//Print all the animal greetings
	public void printAllAnimalGreetings() {
		for (Animal animal: animalList)
			printOneAnimalGreeting(animal);
	}
	
	//Print the greeting of given animal
	public void printOneAnimalGreeting(Animal animal) {
		animal.sayGreeting();
	}
	
	//Print all the animal names
	public void printAllAnimalNames() {
		for (Animal animal: animalList)
			printOneAnimalName(animal);		
	}
	
	//Print the name of given animal
	public void printOneAnimalName(Animal animal) {
		System.out.println(animal.getName());
	}
	
	//Print all animals
	public void printAllAnimals() {
		for (Animal animal: animalList)
			System.out.println(animal.toString());
	}
	
	//Calculate the population of the next year
	public int nextYearPopulationForecast() {
		int totalPopulation = numberOfAnimals;
		
		for (Animal animal: animalList)
			totalPopulation += animal.getNumberOfOffsprings() * animal.getPregnancyPerYear();
		return totalPopulation;
	}
	
	//Print all animal movements
	public void animalMovements() {
		for (Animal animal: animalList) {
			System.out.print("My name is " + animal.getName() + " and ");
			
			//Invoke corresponding method of Bird/Mammal
			if (animal instanceof Bird)
				((Bird) animal).fly();
			else if (animal instanceof Mammal)
				((Mammal) animal).walk();
		}
	}
	
	//Print all eating habits
	public void eatingHabits() {
		for (Animal animal: animalList) {
			System.out.print("My name is " + animal.getName() + " and ");
			
			//Invoke corresponding method of Bird/Mammal
			if (animal instanceof Bird)
				((Bird) animal).omnivore();
			else if (animal instanceof Mammal)
				((Mammal) animal).herbivore();
		}		
	}
	
	//Print the sorted version of animalList based on name
	public void sortAlphabetically() {		
		Animal[] sortedAnimalList = new Animal[animalList.size()];
		
		//Copy all contents from animalList
		for (int i = 0; i < sortedAnimalList.length; ++i)
			sortedAnimalList[i] = animalList.get(i);
		
		//Sort the array selection sort
		for (int i = 0; i < sortedAnimalList.length - 1; ++i) {
			
			int currentMinIndex = i;
			String currentMinName = sortedAnimalList[i].getName();
			
			//Find smallest element lexicographically
			for (int j = i + 1; j < sortedAnimalList.length; ++j)
				if (currentMinName.compareTo(sortedAnimalList[j].getName()) > 0) {
					
					currentMinName = sortedAnimalList[j].getName();
					currentMinIndex = j;
				}
			
			//Swap sortedAnimalList[i] and currentMinName
			if (currentMinIndex != i) {
				
				Animal temp = sortedAnimalList[i];
				sortedAnimalList[i] = sortedAnimalList[currentMinIndex];
				sortedAnimalList[currentMinIndex] = temp;
			}
		}
		
		//Print the sortedAnimalList
		for (Animal animal: sortedAnimalList)
			System.out.println(animal.toString());
	}
	
	//Print the sorted version of animalList based on leg number
	public void sortBasedOnLegNumber() {
		Animal[] sortedAnimalList = new Animal[animalList.size()];
		
		//Copy all contents from animalList
		for (int i = 0; i < sortedAnimalList.length; ++i)
			sortedAnimalList[i] = animalList.get(i);
		
		//Sort the array selection sort
		for (int i = 0; i < sortedAnimalList.length - 1; ++i) {
			
			int currentMinIndex = i;
			int currentMinLegNumber = sortedAnimalList[i].getLegNumber();
			
			//Find smallest leg number
			for (int j = i + 1; j < sortedAnimalList.length; ++j)
				if (sortedAnimalList[j].getLegNumber() < currentMinLegNumber) {
					
					currentMinLegNumber = sortedAnimalList[j].getLegNumber();
					currentMinIndex = j;
				}
			
			//Swap sortedAnimalList[i] and currentMinLegNumber
			if (currentMinIndex != i) {
				
				Animal temp = sortedAnimalList[i];
				sortedAnimalList[i] = sortedAnimalList[currentMinIndex];
				sortedAnimalList[currentMinIndex] = temp;
			}
		}
		
		//Print the sortedAnimalList
		for (Animal animal: sortedAnimalList)
			System.out.printf("%s has %d legs!\n", animal.getName(), animal.getLegNumber());		
	}
	
	//Print the sorted version of animalList based on age
	public void sortBasedOnAge() {
		Animal[] sortedAnimalList = new Animal[animalList.size()];
		
		//Copy all contents from animalList
		for (int i = 0; i < sortedAnimalList.length; ++i)
			sortedAnimalList[i] = animalList.get(i);
		
		//Sort the array selection sort
		for (int i = 0; i < sortedAnimalList.length - 1; ++i) {
			
			int currentMinIndex = i;
			int currentMinAge = sortedAnimalList[i].getAge();
			
			//Find smallest age
			for (int j = i + 1; j < sortedAnimalList.length; ++j)
				if (sortedAnimalList[j].getAge() < currentMinAge) {
					
					currentMinAge = sortedAnimalList[j].getAge();
					currentMinIndex = j;
				}
			
			//Swap sortedAnimalList[i] and currentMinAge
			if (currentMinIndex != i) {
				
				Animal temp = sortedAnimalList[i];
				sortedAnimalList[i] = sortedAnimalList[currentMinIndex];
				sortedAnimalList[currentMinIndex] = temp;
			}
		}
		
		//Print the sortedAnimalList
		for (Animal animal: sortedAnimalList)
			System.out.printf("%s is %d years old!\n", animal.getName(), animal.getAge());
	}
	
	//Print the animal with given name
	public void searchBasedOnName(String name) {
		for (int i = 0; i < animalNames.size(); ++i)
			if (name.equals(animalNames.get(i))) {
				
				System.out.println(animalList.get(i).toString());
				break;
			}
	}
	
	//Print the animals with given age
	public void searchBasedOnAge(int age) {
		for (Animal animal: animalList)
			if (animal.getAge() == age)
				System.out.println(animal.toString());
	}
	
	//Print the information about the animal farm on a file
	public void printReport(String filename) throws FileNotFoundException {
		PrintWriter output = new PrintWriter(filename);
		output.println("We have a total of " + numberOfAnimals + " animals in the farm.\n");
		
		//Print all Chickens
		if (Chicken.getCount() != 0) {
			output.println("    *" + Chicken.getCount() + " of them are Chicken. Those are:");
			output.printf("        %-15s%-15s%s\n", "Name", "Age", "Leg Number");
			
			for (Animal animal: animalList)			
				if (animal instanceof Chicken)
					output.printf("        %-15s%-15s%s\n", animal.getName(), animal.getAge(), animal.getLegNumber());
		}
		
		//Print all Donkeys
		if (Donkey.getCount() != 0) {
			output.println("    *" + Donkey.getCount() + " of them are Donkey. Those are:");
			output.printf("        %-15s%-15s%s\n", "Name", "Age", "Leg Number");
			
			for (Animal animal: animalList)			
				if (animal instanceof Donkey)
					output.printf("        %-15s%-15s%s\n", animal.getName(), animal.getAge(), animal.getLegNumber());
		}
		
		//Print all Horses
		if (Horse.getCount() != 0) {
			output.println("    *" + Horse.getCount() + " of them are Horse. Those are:");
			output.printf("        %-15s%-15s%s\n", "Name", "Age", "Leg Number");
			
			for (Animal animal: animalList)			
				if (animal instanceof Horse)
					output.printf("        %-15s%-15s%s\n", animal.getName(), animal.getAge(), animal.getLegNumber());
		}
		
		//Print all Pigs
		if (Pig.getCount() != 0) {
			output.println("    *" + Pig.getCount() + " of them are Pig. Those are:");
			output.printf("        %-15s%-15s%s\n", "Name", "Age", "Leg Number");
			
			for (Animal animal: animalList)			
				if (animal instanceof Pig)
					output.printf("        %-15s%-15s%s\n", animal.getName(), animal.getAge(), animal.getLegNumber());
		}
		
		//Print all Ravens
		if (Raven.getCount() != 0) {
			output.println("    *" + Raven.getCount() + " of them are Raven. Those are:");
			output.printf("        %-15s%-15s%s\n", "Name", "Age", "Leg Number");
			
			for (Animal animal: animalList)			
				if (animal instanceof Raven)
					output.printf("        %-15s%-15s%s\n", animal.getName(), animal.getAge(), animal.getLegNumber());
		}
		
		//Print all Sheep
		if (Sheep.getCount() != 0) {
			output.println("    *" + Sheep.getCount() + " of them are Sheep. Those are:");
			output.printf("        %-15s%-15s%s\n", "Name", "Age", "Leg Number");
			
			for (Animal animal: animalList)			
				if (animal instanceof Sheep)
					output.printf("        %-15s%-15s%s\n", animal.getName(), animal.getAge(), animal.getLegNumber());
		}
		
		output.close();
	}
}
