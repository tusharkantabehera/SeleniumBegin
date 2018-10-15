package DifferentOperations;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalanderHandlingJavaScript {

    public WebDriver driver;

	@BeforeTest
	public void openUrl()
	{
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com");
	}
	
	@Test
	public void selectDateByJSTest() throws InterruptedException, AWTException
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("Mum");
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("Goa");		
		WebElement ari=driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		WebElement dep=driver.findElement(By.id("ctl00_mainContent_txt_Todate"));
		String date1="11/12/2018";
		String date2="12/12/2018";
		selectDateByJS(driver, ari, date1);
		selectDateByJS(driver, dep, date2);
		
		//mouse clicking on given codinates 
		Actions actions = new Actions(driver);
		Robot robot = new Robot();
		robot.mouseMove(500,150);
		actions.click().build().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
	
	public static void selectDateByJS(WebDriver driver,WebElement element,String date)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+date+"');", element);
	}
}
