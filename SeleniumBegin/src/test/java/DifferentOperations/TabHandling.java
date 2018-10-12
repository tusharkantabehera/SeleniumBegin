package DifferentOperations;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TabHandling {
	
	  WebDriver driver;
		
		@BeforeTest
		public void openBrowser()
		{
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
//			System.setProperty("webdriver.firefox.marionette", ".\\resources\\geckodriver.exe");
//			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		}
		
		@Test
		public void openpage() throws InterruptedException
		{
			driver.get("http://toolsqa.com/automation-practice-switch-windows/");
			String parentTab=driver.getWindowHandle();
			driver.findElement(By.id("button1")).click();
			Thread.sleep(2000);
			ArrayList<String> tabids=new ArrayList<String>(driver.getWindowHandles());  //
			tabids.remove(parentTab);
			driver.switchTo().window(tabids.get(0));
			System.out.println(driver.getTitle());
			driver.quit();
			driver.switchTo().window(parentTab);
			driver.quit();

		}
		

		
}
