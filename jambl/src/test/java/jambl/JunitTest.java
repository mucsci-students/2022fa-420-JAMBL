package jambl;
import jambl.Model.*;
import jambl.Model.Class;
import jambl.Controller.*;

/*
 * @name JunitTest.java
 * @author John Shenk
 * @description An example of a JUnit test class
 *  Note each method starts with '@Test' and the methods have an "assertEquals() function"
 */


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;
import java.util.HashSet;


public class JunitTest {


	 Class newClass = null;
	 Class newClass2 = null;
	 String typeName;
	 String fieldName;
	 String oldFieldName;
	 String oldFieldType;
	 String newFieldName;
	 String newFieldType;
	 String fieldType;

   // Assures us that JUnit is working properly
   @Test
   public void testAdd() {
      String str = "Junit is working fine";
      assertEquals("Junit is working fine",str);
   }

   // Tests the functionality of creating a new class with the name "History"
   @Test
   public void testNewClass(){
      Class newClass = new Class("History");
      assertEquals("History", newClass.getClassName());
   }

   //Tests the functionality of adding a class
   @Test
   public void testAddClass(){
      Model newModel = new Model();
      newModel.addClass("English");
      assertEquals("English", newModel.getClass("English").getClassName());
   }

   // Tests the functionality of renaming a class
   @Test
   public void testRenameClass(){
      Model newModel = new Model();
      newModel.addClass("Science");
      newModel.renameClass("Science", "Art");
      assertEquals("Art", newModel.getClass("Art").getClassName());
   }

   //Tests the functionality of deleting a class
   @Test 
   public void testDeleteClass(){
      Model newModel = new Model();
      newModel.addClass("Gym");
      newModel.deleteClass(newModel.getClass("Gym"));
      assertEquals(null, newModel.getClass("Gym"));
   }

   // Tests to see if deleting a class that doesn't exist
   @Test 
   public void testDeleteClass2(){
     Model newModel = new Model();
	 Class cls = new Class("Gym"); //this class doesnt exist inside the model so it cant be removed
     assertEquals(false, newModel.deleteClass(cls));
   }

   //Test deleting a class that is in a relationship
   @Test
   public void testDeleteClassinRel () {
		Model model = new Model();
		model.addClass("Tire");
		model.addClass("Car");
		model.getClass("Tire").addRelationship(model.getClass("Car"), "AGGR");
		model.deleteClass(model.getClass("Car"));
		assertNull(model.getClass("Tire").getRelationship("Car"));
   }
	   
		// Tests the functionality of getting class name
	   @Test
	   public void testgetClassName() {
		   newClass = new Class("Movie");  
		   assertEquals("Movie", newClass.getClassName());
	   }
	   
	   // Tests the functionality of setting class name
	   @Test
	   public void testsetClassName() {
		   newClass = new Class("xyxy");
		   String expected = "Movie";
		   newClass.setClassName("Movie");
		   String result = newClass.getClassName();
		   assertEquals(expected, result);
	   }

	   //Tests getting the set of classes
		@Test
		public void testGetClassSet() {
			Model newModel = new Model();
			newModel.addClass("Class1");
			newModel.addClass("Class2");
			HashSet<Class> clsSet = newModel.getClasses();
			assertEquals(2, clsSet.size());
		}

	   //Tests getting the set of fields of a class
	   @Test
	   public void testGetFieldSet() {
			Class cls = new Class("Class");
			cls.addField("name", "String");
			HashSet<Field> mtdSet = cls.getFields();
			assertEquals(mtdSet.size(), 1);

	   }

	   // Tests the functionality of adding relationship to a class
	   @Test 
	   public void testaddRelationship() {
		   newClass = new Class("Movie");
		   newClass2 = new Class("Director");
		   String typeName = "COMP";
		   newClass.addRelationship(newClass2, typeName);
		   HashSet<Relationship> result = newClass.getRelationships();
		  assertEquals(1, result.size());
	   }
	   
	   // Tests the functionality of deleting relationship of a class
	   @Test
	   public void testdeleteRelationship() {
		   
		   newClass = new Class("Movie");
		   newClass2 = new Class("Director");
		   String typeName = "COMP";
		   newClass.addRelationship(newClass2, typeName);
		   newClass.deleteRelationship("Director");
		   HashSet<Relationship> result = newClass.getRelationships() ;
		  assertEquals(0, result.size());		   
	   }

	    // Tests the functionality of getting class destination
	   @Test
	   public void testgetDestination() {
			typeName = "COMP";
		    newClass = new Class("Movie");
			Relationship newRel = new Relationship(newClass, typeName);
			assertEquals("Movie", newRel.getDestination().getClassName());
			   
	   }

	//Test for a relationship that already exists to that class
	@Test
	public void testExistingRelationship () {
		Class origin = new Class("Tire");
		Class destination = new Class("Car");
		origin.addRelationship(destination, "COMP");
		assertTrue(origin.isRelationshipExist("Car"));
	}

	//Test for a relationship that already does not exist to that class
	@Test
	public void testNotExistingRelationship () {
		Class origin = new Class("Tire");
		Class destination = new Class("Car");
		origin.addRelationship(destination, "COMP");
		assertFalse(origin.isRelationshipExist("Door"));
	}

	//Test for getting an existing relationship
	@Test
	public void testGetExistingRelationship () {
		Class origin = new Class("Tire");
		Class destination = new Class("Car");
		origin.addRelationship(destination, "COMP");
		assertNotNull(origin.getRelationship("Car"));
	}

	//Test for getting an existing relationship
	@Test
	public void testGetNonExistingRelationship () {
		Class origin = new Class("Tire");
		Class destination = new Class("Car");
		origin.addRelationship(destination, "COMP");
		assertNull(origin.getRelationship("Door"));
	}

	//Test for getting an existing relationship
	@Test
	public void testEditRelationship () {
		Class origin = new Class("Tire");
		Class destination = new Class("Car");
		origin.addRelationship(destination, "COMP");
		origin.editRelationshipType("Car", "AGGR");
		assertTrue(origin.getRelationship("car").getRelType().equals("AGGR"));
	}

	//Test for true valid Realtionship type
	@Test
	public void testValidRelType () {
		Class origin = new Class("Tire");
		assertTrue(origin.isValidType("AGGR"));
	}

	//Test for false valid Realtionship type
	@Test
	public void testNotValidRelType () {
		Class origin = new Class("Tire");
		assertFalse(origin.isValidType("Connection"));
	}

	//Test for getting full name of a given relationship
	@Test
	public void testFullRelName () {
		Class origin  = new Class("Tire");
		assertTrue(origin.TypefullName("AGGR").equals("AGGREGATION"));
	}

	//Test the Relationship Type enum string short nameconversion
	@Test
	public void testTypeToString () {
		String testType = "AGGR";
		assertTrue(Relationship.Type.AGGR.toString().equals(testType));
	}

	//Test Relationship Type enum string full name conversion
	@Test
	public void testTypeFullName () {
		String testType = "AGGREGATION";
		assertTrue(Relationship.Type.AGGR.fullName().equals(testType));
	}

	//Test getting the full relationship type name from a relationship that exists
	@Test
	public void testGetFullType () {
		Class origin = new Class ("Tire");
		Class destination = new Class ("Car");
		origin.addRelationship(destination, "AGGR");
		Relationship rel = origin.getRelationship(destination.getClassName());
		assertTrue(rel.getFullType().equals("AGGREGATION"));
	}

	// Tests the functionality of adding a method to a class
	@Test
	public void testAddMethod() {
		String clsName = "Tire";
		String mtdName = "setPSI";
		String mtdType = "void";
		Class cls = new Class (clsName);
		cls.addMethod(mtdName, mtdType);
		assertTrue(cls.getMethod(mtdName).getMethodName().equals(mtdName) && cls.getMethod(mtdName).getReturnType().equals(mtdType));

	}

	// Tests the functionality of deleting a method from a class
	@Test
	public void testDeleteMethod() {
		String clsName = "Tire";
		String mtdName = "setPSI";
		String mtdType = "void";
		Class cls = new Class (clsName);
		cls.addMethod(mtdName, mtdType);
		cls.deleteMethod(cls.getMethod(mtdName));
		assertEquals(0, cls.getMethods().size());
	}

	// Tests the functionality of renaming a method in a class
	@Test
	public void testRenameMethod() {
		String clsName = "Tire";
		String mtdName = "setPSI";
		String mtdType = "void";
		Class cls = new Class (clsName);
		cls.addMethod(mtdName, mtdType);
		String newName = "getPSI";
		cls.renameMethod(cls.getMethod(mtdName), newName);
		assertTrue(cls.getMethod(newName) != null && cls.getMethod(mtdName) == null);
	}

		// Tests the functionality of changing the return type of a method in a class
		@Test
		public void testRetypeMethod() {
			String clsName = "Tire";
			String mtdName = "setPSI";
			String mtdType = "void";
			Class cls = new Class (clsName);
			cls.addMethod(mtdName, mtdType);
			String newType = "float";
			cls.changeMethodreturn(cls.getMethod(mtdName), newType);
			assertEquals(cls.getMethod(mtdName).getReturnType(), newType);
		}

		// Tests the functionality of adding a Field to a Class and assuring name is set
		@Test
		public void testAddFieldGetName(){
			newClass = new Class("Item");
			fieldName = "price"; // Testing on this
			fieldType = "double";
			newClass.addField(fieldName, fieldType);
			String result = newClass.getField(fieldName).getFieldName();
			assertEquals(fieldName, result);
		}

		// Tests functionality of adding a Field to a Class and assuring type is set
		@Test
		public void testAddFieldGetType(){
			newClass = new Class("Item");
			fieldName = "price";
			fieldType = "double"; // Testing on this
			newClass.addField(fieldName, fieldType);
			String result = newClass.getField(fieldName).getFieldType();
			assertEquals(fieldType, result);
		}

		// Tests getting a field that does not exist in the class
		@Test
		public void testGetNonExistingField () {
			newClass = new Class("Item");
			newClass.addField("price", "double");
			newClass.addField("weight", "double");
			assertNull(newClass.getField("quantity"));
		}

		// Tests the functionality of deleting a Field that exists in a class
		@Test
		public void testDeleteFieldThatExists(){
			newClass = new Class("Zoo");
			fieldName = "animals";
			fieldType = "HashSet<String>";
			newClass.addField(fieldName, fieldType);
			assertTrue(newClass.deleteField(fieldName));
		}

		// Tests the functionality of deleting a Field that does not exist in a class
		@Test
		public void testDeleteFieldThatDoesNotExist(){
			newClass = new Class("Item");
			fieldName = "quantity";
			fieldType = "int";
			newClass.addField(fieldName, fieldType);
			assertFalse(newClass.deleteField("price")); // Did not add "price" field, should return false
		}

		// Tests the functionality of renaming a Field that exists in a class
		@Test
		public void testRenameFieldThatExists(){
			newClass = new Class("Keyboard");
			oldFieldName = "escape";
			fieldType = "Key";
			newClass.addField(oldFieldName, fieldType);
			newFieldName = "tab";
			newClass.renameField(oldFieldName, newFieldName);
			String result = newClass.getField(newFieldName).getFieldName();
			assertEquals(newFieldName, result);
		}

		// Test whether the rename field method returns true when you correct rename field
		@Test
		public void testRenameFieldReturnsTrue() {
			Class newClass = new Class("Keyboard");
			oldFieldName = "escape";
			fieldType = "Key";
			newClass.addField(oldFieldName, fieldType);
			newFieldName = "tab";
			assertTrue(newClass.renameField(oldFieldName, newFieldName));
		}

		// Tests the functionality of renaming a Field that does not exist in a class
		@Test 
		public void testRenameFieldThatDoesNotExist(){
			newClass = new Class("Keyboard");
			oldFieldName = "tab";
			newFieldName = "shift";
			assertFalse(newClass.renameField(oldFieldName, newFieldName));
		}

		// Tests the functionality of changing the type of a Field that exists within a class=
		@Test
		public void testChangeFieldTypeThatExists(){
			newClass = new Class("Vehicle");
			fieldName = "price";
			oldFieldType = "int";
			newClass.addField(fieldName, oldFieldType);
			newFieldType = "double";
			newClass.changefieldType(fieldName, newFieldType);
			String result = newClass.getField(fieldName).getFieldType();
			assertEquals(newFieldType, result);
		}

		// Tests the functionality of attempting to change the type of a Field that does not exist within a class
		@Test
		public void testChangeFieldTypeNotExist(){
			newClass = new Class("Vehicle");
			fieldName = "price";
			fieldType = "double";
			newClass.addField(fieldName, fieldType);
			String fieldName2 = "make";
			assertFalse(newClass.changefieldType(fieldName2, "String"));	
		}

		// Tests the functionality of adding a parameter to a method
		@Test
		public void testaddParameter(){
			Method newMethod = new Method("xyxy", "String");
			newMethod.addParameter("name1", "String");
			assertEquals("name1", newMethod.getParameter("name1").getParamName());
		}


		// Tests the functionality of deleting a parameter from a method
		@Test
		public void testdeleteParameter(){
			Method newMethod = new Method("xyxy", "String");
			newMethod.addParameter("name2", "String");
			newMethod.deleteParameter("name2");
			assertEquals(null, newMethod.getParameter("name2"));
		}
		
		// Tests the functionality of changing the name of a parameter
		@Test
		public void testchangeParameterName(){
			Method newMethod = new Method("xyxy", "String");
			newMethod.addParameter("name3", "String");
			newMethod.changeParameter("name3", "game3", "int");
			assertEquals("game3", newMethod.getParameter("game3").getParamName());
		}


		// Tests the functionality of changing the type of a parameter
		@Test
		public void testchangeParameterType(){
			Method newMethod = new Method("xyxy", "String");
			newMethod.addParameter("name3", "String");
			newMethod.changeParameter("name3", "game4", "int");
			assertEquals("int", newMethod.getParameter("game4").getParamType());
		}

		// Tests the functionality of deleting all parameters from a method
		@Test
		public void testdeleteAllParameter(){
			Method newMethod = new Method("xyxy", "String");
			newMethod.addParameter("name2", "String");
			newMethod.addParameter("name5", "int");
			newMethod.deleteAllParameter();
			assertEquals(true, newMethod.getParameters().isEmpty());
		}

		//Test changing a parameter that doesnt exist
		@Test
		public void testChangeParamNotExist () {
			Method mtd = new Method("addItems", "void");
			mtd.addParameter("item1", "int");
			mtd.addParameter("item2", "int");
			assertFalse(mtd.changeParameter("item3", "item4", "int"));
		}

		//Test deleting a parameter that doesnt exist
		@Test
		public void testDeleteParamNotExist () {
			Method mtd = new Method("addItems", "void");
			mtd.addParameter("item1", "int");
			mtd.addParameter("item2", "int");
			assertFalse(mtd.deleteParameter("item3"));
		}

		//Test getParamName
		@Test
		public void testGetParameterName () {
			Method mtd = new Method("method", "int");
			mtd.addParameter("name1", "String");
			assertEquals("name1", mtd.getParameter("name1").getParamName());
		}

		//Test setting the X of a class
		@Test
		public void testSetX () {
			Class cls = new Class("Tire");
			cls.addX(100);
			assertEquals(100, cls.getX());
		}

		//Test setting the Y of a class
		@Test
		public void testSetY () {
			Class cls = new Class("Tire");
			cls.addY(100);
			assertEquals(100, cls.getY());
		}

		// Test edit relationship when multiple relationships exist
		@Test 
		public void testEditManyRelationships () {
			Class origin = new Class("Item");
			Class destination = new Class("Car");
			Class origin2 = new Class("Item2");
			Class origin3 = new Class("Item3");
			origin.addRelationship(destination, "COMP");
			origin2.addRelationship(destination, "AGGR");
			origin3.addRelationship(destination, "AGGR");
			origin3.editRelationshipType("Car", "COMP");
			assertEquals("COMP", origin3.getRelationship("Car").getRelType());
		}

}