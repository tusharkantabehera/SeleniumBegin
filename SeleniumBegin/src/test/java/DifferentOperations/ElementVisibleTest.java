package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementVisibleTest {
	
	    public WebDriver driver;

		@BeforeTest
		public void openUrl()
		{
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://www.freecrm.com");
		}
		
		@Test(priority=1)
		public void isDisplayedTest() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a/font[text()='Sign Up']")).click();
			
			//"submit button" is displaying but not enabled
			boolean b=driver.findElement(By.xpath("//*[@id='submitButton']")).isDisplayed();  
			System.out.println(b);  //true
			

		}
		
		@Test(priority=2)
		public void isEnabledTest() throws InterruptedException
		{
			//"submit button" is displaying but not enabled
			boolean b1=driver.findElement(By.xpath("//*[@id='submitButton']")).isEnabled();
			System.out.println(b1); //false
			
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();  //clicking on check-box
			Thread.sleep(2000);
			
			//Now "submit button" is enabled
			boolean b2=driver.findElement(By.xpath("//*[@id='submitButton']")).isEnabled();
			System.out.println(b2); //true

		}
		
		@Test(priority=3)
		public void isSelectedTest()
		{
			boolean b1=driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
			System.out.println(b1); //true as check-box is selected previously
			
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			//Now check-box is unselected
			
			boolean b2=driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
			System.out.println(b2); //false
			
		}
		
		@AfterTest
		public void closeBrowser()
		{
			driver.quit();
		}
}


/*Difference between isDisplayed(), isEnabled() and isSelected() Methods in Selenium WebDriver:

1. isDisplayed() is the method used to verify the presence of a web element within the web page. 
   The method returns a “true” value if the specified web element is present on the web page and
   a “false” value if the web element is not present on the web-page.
2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
4. isEnabled() is primarily used with buttons.
5. isSelected() is the method used to verify if the web element is selected or not. 6. isSelected() method is 
   predominantly used with radio buttons, drop-downs and check-boxes.

*/
