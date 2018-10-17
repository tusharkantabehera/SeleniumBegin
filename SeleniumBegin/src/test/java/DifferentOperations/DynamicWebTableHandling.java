package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebTableHandling {
	
	        public WebDriver driver;

			@BeforeTest
			public void openUrl()
			{
				System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
				driver=new ChromeDriver();	
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				driver.get("https://www.freecrm.com");
			}
			
			@BeforeMethod 
			public void login() throws InterruptedException
			{
				Thread.sleep(3000);	
				driver.findElement(By.name("username")).sendKeys("tusharkec143");
				driver.findElement(By.name("password")).sendKeys("lenovopc@12");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				Thread.sleep(5000);		
			}
			
			@Test
			public void selectContactMethod_1() throws InterruptedException
			{
				driver.switchTo().frame("mainpanel");
				driver.findElement(By.xpath("//a[@title='Contacts']")).click();
				
				//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
				//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
				//*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
				//*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
				
				String before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
				String after_xpath="]/td[2]/a";
				
				for(int i=4;i<=7;i++)
				{
					String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
					System.out.println(name);
					if(name.contains("Test3 Test"))
					{
						//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
						
						driver.findElement(By.xpath(before_xpath+i+"]/td[1]/input")).click();
					}
				}
			}
			
			@Test
			public void selectContactMethod_2()
			{
				driver.switchTo().frame("mainpanel");
				driver.findElement(By.xpath("//a[@title='Contacts']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Test2 Test')]/../preceding-sibling::td/input")).click();
			}
			
			@AfterMethod
			public void logout()
			{
				driver.findElement(By.partialLinkText("Logout")).click();
			}
			
			@AfterTest
			public void closeBrowser()
			{
				driver.quit();
			}
			
}
