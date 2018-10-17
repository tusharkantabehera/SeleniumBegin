package Log4JTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMLog4j {
	

	public WebDriver driver;
	Logger log;
	
	@BeforeMethod 
	public void openUrl() throws InterruptedException
	{   
		log=Logger.getLogger("CRMPRO");
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		log.info("Browser opened");
		driver.manage().window().maximize();
		log.info("Browser maximized");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		log.info("Opening URL");
		driver.get("https://www.freecrm.com");	
		log.info("Waiting gor 3 sec");
		Thread.sleep(3000);	
	}

	@Test
	public void login() throws InterruptedException 
	{	
		log.warn("Entering username and password");
		driver.findElement(By.name("username")).sendKeys("tusharkec143");
		driver.findElement(By.name("password")).sendKeys("lenovopc@12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		log.info("Logging in");
		Thread.sleep(3000);		
	}
	
	@Test
	public void titleTest()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		log.info("title varified");
	}
	
	@Test
	public void logoTest()
	{
		boolean b=driver.findElement(By.xpath("//img[@class='img-responsive' and @alt='free crm logo']")).isDisplayed();
		Assert.assertTrue(b);
		log.info("Logo verified");
	}
	
	@AfterMethod
	public void exitBrowser()
	{
		driver.quit();
		log.info("Browser closed");
	}
}
