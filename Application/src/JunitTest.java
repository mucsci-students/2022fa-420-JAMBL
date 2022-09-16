/*
 * @name JunitTest.java
 * @author John Shenk
 * @description An example of a JUnit test class
 *  Note each method starts with '@Test' and the methods have an "assertEquals() function"
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JunitTest {

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
}