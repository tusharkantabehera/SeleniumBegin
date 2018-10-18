package Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitlyWait {           
	
	  WebDriver driver;
		
		@Test
		public void openBrowser()
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://facebook.com");
			WebElement element=driver.findElement(By.xpath("//input[@type='submit']"));
			clickOn(driver, element, 20, 5);
		}
		
		 //Explicit wait
		public static void clickOn(WebDriver driver,WebElement element,int timeout,int poolingTime)
		{
			new WebDriverWait(driver, timeout)
			.ignoring(StaleElementReferenceException.class)
			.pollingEvery(poolingTime, TimeUnit.SECONDS)
			.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
}

