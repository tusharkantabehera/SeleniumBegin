package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthenticationPopup {

    	public WebDriver driver;

		@BeforeMethod 
		public void login() throws InterruptedException
		{   
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		}
	
		@Test
		public void authenticationTest() 
		{
			//URL:-https://username:password@sampleurl.com
			driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
			String msg=driver.findElement(By.cssSelector("p")).getText();
			System.out.println(msg);
		}
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
		}
}
