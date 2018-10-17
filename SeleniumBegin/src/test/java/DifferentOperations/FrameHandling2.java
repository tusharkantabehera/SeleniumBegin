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

public class FrameHandling2 {
	
    WebDriver driver;
	
	@BeforeTest
	public void openUrl()
	{
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
	}
	
	@Test
	public void numberOfFrame()
	{
//	     By executing a java script
		
//	     JavascriptExecutor exe = (JavascriptExecutor) driver;
//		 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
//		 System.out.println("Number of iframes on the page are " + numberOfFrames);
		
		//By finding all the web elements using iframe tag
		
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
	}
	
	@Test
	public void SwitchToFrame()
	{
		//driver.switchTo().frame(0);           //Using frame ID
		
		//driver.switchTo().frame("iframe1");   //Using frame name
		
		//By using WebElement
		WebElement iframeElement = driver.findElement(By.id("IF1"));
		driver.switchTo().frame(iframeElement);
		
		driver.switchTo().defaultContent();    //Back to main-page from frame
		
	}
	
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
}
