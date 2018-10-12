package DifferentOperations;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HtmlPopupHandle {
	
	WebDriver driver;
	@BeforeTest
	public void openmail()
	{
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://html.com/input-type-file/");
	}
	
	@Test()
	public void closePopup() throws InterruptedException
	{
		Thread.sleep(5000);

		try
		{
	    WebElement pop=driver.findElement(By.xpath("//div[@id='miami-element-title-content']"));
		if(pop.isDisplayed())
		{
		String msg=driver.findElement(By.xpath("//div[@id='miami-element-title-content']")).getText();
		System.out.println(msg);
		driver.findElement(By.xpath("//div[@id='om-lightbox-postal-optin-wrap']/a[@title='Close']")).click();
		}
		}catch(NoSuchElementException e)
		{
		    System.out.println("Popup not displayed");
		    new SkipException("Popup not displayed");
		}
	}
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}

}
