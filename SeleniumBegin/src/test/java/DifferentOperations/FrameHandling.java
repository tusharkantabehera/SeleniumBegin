package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameHandling {
	
    WebDriver driver;
	
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
	
	@Test
	public void login() throws InterruptedException 
	{
		driver.findElement(By.name("username")).sendKeys("tusharkec143");
		driver.findElement(By.name("password")).sendKeys("lenovopc@12");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(7000);		
	}
	
	@Test
	public void frame() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
	}
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}

}
