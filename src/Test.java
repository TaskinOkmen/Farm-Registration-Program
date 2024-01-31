//This Program simulates an animal farm and performs various operations by selections from the menus
//TAŞKIN ÖKMEN 150122019

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Animal Farm simulation program!");
		System.out.print("Please enter the capacity of the animal farm: ");
		//Create and initialize animalFarm
		AnimalFarm animalFarm = new AnimalFarm(input.nextInt());
		
		while (true) {
			//Print the selection menu
			System.out.print("0 - Exit the program\n1 - Add animal\n2 - Remove animal\n"
					+ "3 - Search animal\n4 - Sort animals\n5 - Calculate next year's population estimate\n"
					+ "6 - Print all animal's movements\n7 - Print all animal's eating habits\n"
					+ "8 - Print report\nPlease enter your choice:");
			int choice = input.nextInt();
			
			//Exit the program
			if (choice == 0) break;
			
			//Add animal
			else if (choice == 1) {
				System.out.print("1 - Chicken\n2 - Donkey\n3 - Horse\n4 - Pig\n"
						+ "5 - Raven\n6 - Sheep\nSelect animal type:");
				int animalType = input.nextInt();
				
				System.out.print("Enter the name:");
				String name = input.next();
				
				System.out.print("Enter the age:");
				int age = input.nextInt();
				
				try {
					//Add the animal type based on choice
					switch (animalType) {
						case 1:
							animalFarm.addAnimal(new Chicken(name, age));
							break;
						case 2:
							animalFarm.addAnimal(new Donkey(name, age));
							break;
						case 3:
							animalFarm.addAnimal(new Horse(name, age));
							break;
						case 4:
							animalFarm.addAnimal(new Pig(name, age));
							break;
						case 5:
							animalFarm.addAnimal(new Raven(name, age));
							break;
						case 6:
							animalFarm.addAnimal(new Sheep(name, age));
					}	
				}
				catch (IllegalNameException ex) {
					System.out.println(ex.toString());
				}
			}
			
			//Remove animal
			else if (choice == 2) {
				System.out.print("Enter the name of the animal:");
				animalFarm.removeAnimal(input.next());
			}
			
			//Search animal
			else if (choice == 3) {
				System.out.println("1 - Search based on name\n2 - Search based on age");
				int choice2 = input.nextInt();
				
				//Search based on name
				if (choice2 == 1) {
					System.out.print("Enter name:");
					animalFarm.searchBasedOnName(input.next());
				}
				//Search based on age
				else if (choice2 == 2) {
					System.out.print("Enter age:");
					animalFarm.searchBasedOnAge(input.nextInt());
				}
			}
			
			//Sort animals
			else if (choice == 4) {
				System.out.println("1 - Sort based on name\n2 - Sort based on leg number\n"
						+ "3 - Sort based on age\n4 - Sort based on addition date");
				int choice2 = input.nextInt();
				
				//Sort animals based on choice
				switch (choice2) {
					case 1:
						animalFarm.sortAlphabetically();
						break;
					case 2:
						animalFarm.sortBasedOnLegNumber();
						break;
					case 3:
						animalFarm.sortBasedOnAge();
						break;
					case 4:
						animalFarm.printAllAnimals();	
				}
			}
			
			//Calculate next year's population estimate
			else if (choice == 5)
				System.out.println(animalFarm.nextYearPopulationForecast());
			
			//Print all animal's movements
			else if (choice == 6)
				animalFarm.animalMovements();
			
			//Print all animal's eating habits
			else if (choice == 7)
				animalFarm.eatingHabits();
			
			//Print report
			else if (choice == 8) {
				System.out.print("Enter filename:");
				
				try {
					animalFarm.printReport(input.next());
				}
				catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		}
		input.close();
	}
}
