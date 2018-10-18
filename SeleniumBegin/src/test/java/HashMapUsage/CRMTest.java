package HashMapUsage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMTest {

	public WebDriver driver;

	@BeforeMethod
	public void login() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		Thread.sleep(3000);
	}
	
	@Test
	public void adminLogin() throws InterruptedException
	{
		String creds=Data.UserLoginCreds().get("admin");
		String[] admin=creds.split("_");
		
		driver.findElement(By.name("username")).sendKeys(admin[0]);
		driver.findElement(By.name("password")).sendKeys(admin[1]);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);	
		
		driver.switchTo().frame("mainpanel");
		Select select=new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(Data.monthMap().get(5));
	}
	
	@Test(enabled=true)
	public void userLogin() throws InterruptedException
	{

		String creds=Data.UserLoginCreds().get("user");
		String[] admin=creds.split("_");
		
		driver.findElement(By.name("username")).sendKeys(admin[0]);
		driver.findElement(By.name("password")).sendKeys(admin[1]);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}