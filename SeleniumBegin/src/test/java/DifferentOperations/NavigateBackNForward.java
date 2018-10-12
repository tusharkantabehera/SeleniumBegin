package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigateBackNForward {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void navigateBackNForward() throws InterruptedException
	{
		driver.get("https://google.com");
		Thread.sleep(2000);
		driver.navigate().to("https://amazon.in");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().forward();
	}
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
}
