/*
 * @name JunitTest.java
 * @author John Shenk
 * @description An example of a JUnit test class
 *  Note each method starts with '@Test' and the methods have an "assertEquals() function"
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JunitTest {

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
}