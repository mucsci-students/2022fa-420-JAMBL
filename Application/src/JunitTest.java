/*
 * @name JunitTest.java
 * @author John Shenk
 * @description An example of a JUnit test class
 *  Note each method starts with '@Test' and the methods have an "assertEquals() function"
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Before;

public class JunitTest {


	 Attribute newAtt = null;
	
	// Assures us that JUnit is working properly
	   @Test
	   public void testAdd() {
	      String str = "Junit is working fine";
	      assertEquals("Junit is working fine",str);
	   }

	   // Tests the functionality of adding a new class with the name "History"
	   @Test
	   public void testNewClass(){
	      Class newClass = new Class("History");
	      assertEquals("History", newClass.getClassName());
	   }

	   @Test
	   public void testRenameClass(){
	      Model newModel = new Model();
	      newModel.addClass("Science");
	      newModel.renameClass("Science", "Art");
	      assertEquals("Art", newModel.getClass("Art").getClassName());
	   }
	   
	     
	   
	   @Test
	   public void testgetReltionships() {
		   Model model = new  Model();
		   Class desClass = new Class("Director"); 
		   model.addClass("Movie");
		   model.addClass("Director");
		   model.getClass("Movie").addRelationship(desClass);
		   assertTrue(model.getClass("Movie").addRelationship(desClass));
	   }
	   
	   @Test
	   public void testsetAttributes() {
		   HashSet<Attribute> getSetsAtt = new HashSet<Attribute>();
	   }
	 
	   @Test
	   public void testgetClassName() {
		   Class newClass = new Class("Movie");  
		   assertEquals("Movie", newClass.getClassName());
	   }
	   
	   @Test
	   public void testsetClassName() {
		   Class newClass = new Class("xyxy");
		   String expected = "Movie";
		   newClass.setClassName("Movie");
		   String result = newClass.getClassName();
		   assertEquals(expected, result);
	   }
	   
	   @Test 
	   public void testaddRelationship() {
		   Class newClass = new Class("Movie");
		   Class newClass2 = new Class("Director");
		   newClass.addRelationship(newClass2);
		   HashSet<Relationship> result = newClass.getRelationships();
		  
	   }
	
		@Test
	   public void testgetAttName() {
	    newAtt = new Attribute("Genre");  
	   assertEquals("Genre", newAtt.getAttName());
	   }
	   
	   @Test
	   public void testsetAttName() {
		  newAtt = new Attribute("Genre");
		   String expected = "Year";
		   newAtt.setAttName("Year");
		   String result = newAtt.getAttName();
		  assertEquals(expected, result);
	   }


}
