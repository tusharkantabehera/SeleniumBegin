package TestNG;

import org.testng.annotations.Test;

public class IgnorTest {

	@Test (enabled=true)
	 public void printClass2(){
	 System.out.println("This is Test Case 2");
	 }
}
