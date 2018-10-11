package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNG.ITestListenerDemo.class)

public class ITestListenerTest {  
	
  int i=0;
  WebDriver driver;
  
  // Test to pass as to verify listeners . 
  @Test(priority=1) 
  public void TestToPass() 
  { 
	  driver=new FirefoxDriver();
      System.out.println("This method to pass test"); 
      driver.get("https://www.softwaretestingmaterial.com/100-software-testing-interview-questions/"); 
      driver.getTitle();
      driver.quit();
  } 
  //Used skip exception to skip the test
 
  @Test(priority=2)
  public void TestToSkip ()
  {
             System.out.println("This method to skip test");
      throw new SkipException("Skipping - This is not ready for testing ");
  }
  // In the above method, we have already closed the browser. So we couldnot get the title here. It is to forcefully fail the test 
  
  @Test(priority=3) 
  public void TestToFail() 
  { 
      driver.getTitle();
      System.out.println("This method to test fail"); 
  }
  
  @Test(successPercentage=60,invocationCount=5)
  public void test03() {
	  i++;
	  if(i==1 || i==2)
	  {
		  System.out.println("Testcase failed");
		  Assert.assertTrue(false);
	  }
  }
}
