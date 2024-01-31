//This Class creates a template for IllegalNameException Object
//TAŞKIN ÖKMEN 150122019

public class IllegalNameException extends Exception {
	private String name;
	
	//Construct the exception with given name
	public IllegalNameException(String name) {
		super("The animal " + name + " already exists.");
		this.name = name;
	}
	
	//Getter method for name
	public String getName() {
		return name;
	}
}
