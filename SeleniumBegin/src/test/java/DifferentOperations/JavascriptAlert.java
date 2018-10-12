package DifferentOperations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptAlert {
	
	WebDriver driver;
	
	@BeforeTest
	public void openmail()
	{
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@Test
	public void validate() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		if((alert.getText()).equals("Please enter a valid user name"))
				{
				System.out.println("Correct pop-up message");	
				}
		alert.accept();
		
	}
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}

}


/*
 * driver.switchTo().alert(); returns an 'Alert' class object reference 
 * Alert class contains 3 important methods and we can call these method on Alert class object
 * accept() for accept the alert
 * dismiss() for cancel the alert pop-up
 * getText() for get the alert title (Whatever written on the pop-up)
 */