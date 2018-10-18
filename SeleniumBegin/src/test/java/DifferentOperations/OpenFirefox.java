package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenFirefox {
	  WebDriver driver;
		
			@Test
			public void openBrowser()
			{
				System.setProperty("webdriver.firefox.marionette", ".\\src\\main\\resources\\geckodriver.exe");
				driver=new FirefoxDriver();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.get("http://toolsqa.com/automation-practice-switch-windows/");
			}
	
}
