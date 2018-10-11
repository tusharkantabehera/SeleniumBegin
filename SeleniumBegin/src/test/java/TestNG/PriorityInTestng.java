package TestNG;

import org.testng.annotations.Test;

public class PriorityInTestng {
	
  @Test(priority=2)
  public void test02() {
	  System.out.println("priority=2");
  }
  
  @Test(priority=0)
  public void test00() {
	  System.out.println("priority=0");
  }
  
  @Test(priority=1)
  public void test01() {
	  System.out.println("priority=1");
  }
}
