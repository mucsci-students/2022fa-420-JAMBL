package jambl;

/*
 * @name TestRunner.java
 * @author John Shenk
 * @description A test program for JUnit. Should Display "All tests passed :)" if all tests passed.
 */
import java.io.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JunitTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      if(result.wasSuccessful()){
         System.out.print("All tests passed! :)");
      }
   }
}  