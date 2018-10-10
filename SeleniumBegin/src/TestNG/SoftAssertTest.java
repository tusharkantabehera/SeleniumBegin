package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	
	@Test
	public void test01()
	{
		SoftAssert soft=new SoftAssert();
		
		System.out.println("open browser");
		System.out.println("enter username");
		soft.assertTrue(false);
		System.out.println("enter password");
		System.out.println("click on signin button");
		System.out.println("validate the homepage");
		
		soft.assertAll();                              
		//Must required to mark the test fail
	}

	@Test
	public void test02()
	{
		SoftAssert soft=new SoftAssert();
		
		/*We have to create SoftAssert object in each test to get proper result
		otherwise it will fail the test even assertion is true  */
		
		System.out.println("statement-1");
		soft.assertTrue(true);
		System.out.println("statement-2");
		
	}
}

