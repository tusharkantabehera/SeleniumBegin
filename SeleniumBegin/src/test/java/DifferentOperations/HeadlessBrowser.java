package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessBrowser {           //using HtmlUnitDriver
	  WebDriver driver;
		
		@BeforeTest
		public void openUrl()
		{
			driver=new HtmlUnitDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://www.freecrm.com");
		}
		
		@Test
		public void login() throws InterruptedException 
		{ 
			System.out.println(driver.getTitle());
			driver.findElement(By.name("username")).sendKeys("tusharkec143");
			driver.findElement(By.name("password")).sendKeys("lenovopc@12");
			Thread.sleep(3000);	
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			System.out.println(driver.getTitle());
			Thread.sleep(7000);		
		}
}
