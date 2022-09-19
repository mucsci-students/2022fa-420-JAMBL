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


	Attribute newAtt = null;
	 Class newClass = null;
	 Class newClass2 = null;

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
      newModel.deleteClass("Gym");
      assertEquals(null, newModel.getClass("Gym"));
   }

   // Tests to see if deleting a class that doesn't exist
   @Test 
   public void testDeleteClass2(){
     Model newModel = new Model();
     assertEquals(false, newModel.deleteClass("Gym"));
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
		   newClass.addRelationship(newClass2);
		   HashSet<Relationship> result = newClass.getRelationships();
		  assertEquals(1, result.size());
	   }
	   
	   // Tests the functionality of deleting relationship of a class
	   @Test
	   public void testdeleteRelationship() {
		   
		   newClass = new Class("Movie");
		   newClass2 = new Class("Director");
		   newClass.addRelationship(newClass2);
		   newClass.deleteRelationship("Director");
		   HashSet<Relationship> result = newClass.getRelationships() ;
		  assertEquals(0, result.size());
		 
		   
	   }
	   
	   // Tests the functionality of adding attribute to a class
	   @Test
	   public void testaddAttribute() {
		    newAtt = new Attribute("Year");
		   assertEquals("Year", newAtt.getAttName());
	   }
	
	   // Tests the functionality of getting attribute name
		@Test
	   public void testgetAttName() {
	    newAtt = new Attribute("Genre");  
	   assertEquals("Genre", newAtt.getAttName());
	   }
	   
	    // Tests the functionality of setting attribute name
	   @Test
	   public void testsetAttName() {
		  newAtt = new Attribute("Genre");
		   String expected = "Year";
		   newAtt.setAttName("Year");
		   String result = newAtt.getAttName();
		  assertEquals(expected, result);
	   }
	   
	    // Tests the functionality of getting class destination
	   @Test
	   public void testgetDestination() {
		    newClass = new Class("Movie");
			Relationship newRel = new Relationship(newClass);
			assertEquals("Movie", newRel.getDestination().getClassName());
			   
	   }


}