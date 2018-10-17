package Log4JTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMLog4j {
	

	public WebDriver driver;

	@BeforeMethod 
	public void openUrl() throws InterruptedException
	{   
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");	
		Thread.sleep(3000);	
	}

	@Test
	public void login() throws InterruptedException 
	{
		driver.findElement(By.name("username")).sendKeys("tusharkec143");
		driver.findElement(By.name("password")).sendKeys("lenovopc@12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);		
	}
	
	@Test
	public void titleTest()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void logoTest()
	{
		boolean b=driver.findElement(By.xpath("//img[@class='img-responsive' and @alt='free crm logo']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void exitBrowser()
	{
		driver.quit();
	}
}
