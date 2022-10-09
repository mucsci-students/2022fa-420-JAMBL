/*
 * @name JunitTest.java
 * @author John Shenk
 * @description An example of a JUnit test class
 *  Note each method starts with '@Test' and the methods have an "assertEquals() function"
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.*;
import java.util.HashSet;


public class JunitTest {


	 Class newClass = null;
	 Class newClass2 = null;
	 String typeName;

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
	   
	   // Tests the functionality of adding relationship to a class
	   @Test 
	   public void testaddRelationship() {
		   newClass = new Class("Movie");
		   newClass2 = new Class("Director");
		   String typeName = "COMPOSITION";
		   newClass.addRelationship(newClass2, typeName);
		   HashSet<Relationship> result = newClass.getRelationships();
		  assertEquals(1, result.size());
	   }
	   
	   // Tests the functionality of deleting relationship of a class
	   @Test
	   public void testdeleteRelationship() {
		   
		   newClass = new Class("Movie");
		   newClass2 = new Class("Director");
		   String typeName = "COMPOSITION";
		   newClass.addRelationship(newClass2, typeName);
		   newClass.deleteRelationship("Director");
		   HashSet<Relationship> result = newClass.getRelationships() ;
		  assertEquals(0, result.size());
		 
		   
	   }
	   
	   
	    // Tests the functionality of getting class destination
	   @Test
	   public void testgetDestination() {
			typeName = "COMPOSITION";
		    newClass = new Class("Movie");
			Relationship newRel = new Relationship(newClass, typeName);
			assertEquals("Movie", newRel.getDestination().getClassName());
			   
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

}