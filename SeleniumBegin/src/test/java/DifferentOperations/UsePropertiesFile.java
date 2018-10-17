package DifferentOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsePropertiesFile {
	 
	WebDriver driver;
	Properties pro;
		
		@BeforeTest
		public void openBrowser() throws IOException
		{
			pro=new Properties();
			FileInputStream fis=new FileInputStream(".\\src\\test\\java\\DifferentOperations\\Config.properties");
			pro.load(fis);
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		}
		
		@Test
		public void login() throws InterruptedException
		{
			driver.get(pro.getProperty("url"));
			Thread.sleep(3000);
			driver.findElement(By.xpath(pro.getProperty("username_xpath"))).sendKeys(pro.getProperty("username"));
			driver.findElement(By.xpath(pro.getProperty("password_xpath"))).sendKeys(pro.getProperty("password"));
			driver.findElement(By.xpath(pro.getProperty("login_xpath"))).click();
			Thread.sleep(8000);
		}
		
		@Test
		public void closeBrowser()
		{
			driver.quit();
		}
		
}
