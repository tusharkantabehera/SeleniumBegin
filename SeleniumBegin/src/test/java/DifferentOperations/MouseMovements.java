package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseMovements {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@Test()
	public void mouseHover() throws InterruptedException
	{
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//a[@id='highlight-addons']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Hot Meals ']")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void dragNDrop() throws InterruptedException
	{
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		//action.dragAndDrop(source, target).build().perform();     //1st way
		action.clickAndHold(source).moveToElement(target)           //2nd way
		.release()
		.build()
		.perform();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void exitBrowser()
	{
		driver.quit();
	}
}
