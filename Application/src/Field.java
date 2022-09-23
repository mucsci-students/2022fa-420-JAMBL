/*
 * @projectDescription	A program to make UML diagrams.
 * 
 * @authors	John Shenk, Benjamin Slinghoff, Lauryn Simmons, Alex Peiffer, Meba Shimelis
 * @version 0.0.1
 * @dateLastModified September 22, 2022
 * 
 * @classDescription This class represents Fields in a Class diagram
 */

public class Field {
	
	private String fieldName;
	private String fieldType;
	
	// Constructs a new field using a specified name and type
	public Field(String name, String type)
	{
		setFieldName(name);
		setFieldType(type);
	}
	
	// A function that sets the field name
	public void setFieldName(String name)
	{
		this.fieldName = name;
	}
	
	// A function that returns the field name
	public String getFieldName()
	{
		return this.fieldName;
	}
	
	// A function that sets the field type
	public void setFieldType(String type)
	{
		this.fieldType = type;
	}
	
	// A function that returns the field type as a string
	public String getFieldType() {
		return this.fieldType;
	}
}
