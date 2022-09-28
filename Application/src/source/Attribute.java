package source;
/*
 * @projectDescription	A program for adding attribute to a class 
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * 
 * @dateLastModified September 13, 2022
 */

public class Attribute {

	// name of the Attribute
	String attName;

	// Constructor that takes String parameter and sets it as name

	public Attribute(String name) {

		attName = name;
	}

	// sets attribute's Name to given String
	void setAttName(String name) {
		attName = name;
	}

	// returns attribute's Name
	String getAttName() {

		return attName;
	}
}
