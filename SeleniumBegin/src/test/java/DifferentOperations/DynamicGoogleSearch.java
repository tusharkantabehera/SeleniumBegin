package DifferentOperations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicGoogleSearch {
	public WebDriver driver;

	@BeforeTest
	public void openUrl() 
	{
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
	}

	@Test
	public void search() throws InterruptedException
	{
		driver.findElement(By.id("lst-ib")).sendKeys("testing");
		Thread.sleep(2000);
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbqs_c']"));
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
			if(lst.get(i).getText().contains("testing tools"))
			{
				lst.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
