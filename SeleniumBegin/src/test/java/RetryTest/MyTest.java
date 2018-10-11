package RetryTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
	
	@Test()
	public void test01()
	{
		System.out.println("test01");
		Assert.assertEquals(true, false);
	}
	@Test//(retryAnalyzer=RetryTest.RetryAnalyzer.class)
	public void test02()
	{
		System.out.println("test02");
		Assert.assertTrue(false);
	}

}
