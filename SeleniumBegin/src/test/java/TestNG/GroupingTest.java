package TestNG;

import org.testng.annotations.Test;

public class GroupingTest {
	
  @Test(groups= {"sanity"})
  public void test01() {
	  System.out.println("sanity");
  }
  
  @Test(groups= {"sanity","regression"})
  public void test02() {
	  System.out.println("sanity,regression");
  }
  
  @Test(groups= {"regression"})
  public void test03() {
	  System.out.println("regression");
  }
}
