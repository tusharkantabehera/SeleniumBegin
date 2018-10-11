package FailedTestScreenshot;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)

public class MyTest extends Base{
	
	@Test
	public void test01()
	{
		Base.openBrowser();
		Assert.assertTrue(false);
	}

}
