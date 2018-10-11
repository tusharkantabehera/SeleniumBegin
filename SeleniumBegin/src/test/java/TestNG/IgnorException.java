package TestNG;

import org.testng.annotations.Test;

public class IgnorException {

	 @Test(expectedExceptions = ArithmeticException.class)
	 public void testException() {
	 System.out.println("SoftwareTestingMaterial.com");
	 int i = 1 / 0; 
	 System.out.println(i);
	 }
	
}
