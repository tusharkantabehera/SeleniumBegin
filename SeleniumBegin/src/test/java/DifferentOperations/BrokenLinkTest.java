package DifferentOperations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkTest {

    public WebDriver driver;


		@BeforeMethod 
		public void login() throws InterruptedException
		{   
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
		}
	
		@Test(enabled=false)
		public void testBrokenlink_1() throws MalformedURLException, IOException, InterruptedException
		{
			driver.get("https://www.freecrm.com");
			Thread.sleep(3000);	
			driver.findElement(By.name("username")).sendKeys("tusharkec143");
			driver.findElement(By.name("password")).sendKeys("lenovopc@12");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(3000);		
			driver.switchTo().frame("mainpanel");
			List<WebElement> lst=driver.findElements(By.tagName("a"));
			lst.addAll(driver.findElements(By.tagName("img")));
			
			List<WebElement> actLink=new ArrayList<WebElement>();
			
			for(int i=0;i<lst.size();i++)
			{
				
				if(lst.get(i).getAttribute("href")!= null && !lst.get(i).getAttribute("href").contains("javascript"))
				{
					actLink.add(lst.get(i));
					System.out.println(lst.get(i).getAttribute("href"));
				}
			}
			System.out.println("All link are:- "+lst.size());
			System.out.println("Active links size is :- "+actLink.size());
			
			for(int i=0;i<actLink.size();i++)
			{
				HttpURLConnection connection=(HttpURLConnection)new URL(actLink.get(i).getAttribute("href")).openConnection();
				connection.connect();
				String responce=connection.getResponseMessage();
				connection.disconnect();
				System.out.println(actLink.get(i).getAttribute("href")+"---->"+responce);
			}
		}
		
		@Test
		public void testBrokenlink_2() throws IOException, InterruptedException
		{
			driver.get("https://makemysushi.com/404");
			Thread.sleep(3000);	
	
			List<WebElement> lst=driver.findElements(By.tagName("a"));
			lst.addAll(driver.findElements(By.tagName("img")));
			
			List<WebElement> actLink=new ArrayList<WebElement>();
			
			for(int i=0;i<lst.size();i++)
			{
				
				if(lst.get(i).getAttribute("href")!= null && !lst.get(i).getAttribute("href").contains("mail"))
				{
					actLink.add(lst.get(i));
					System.out.println(lst.get(i).getAttribute("href"));
				}
			}
			System.out.println("All link size is :- "+lst.size());
			System.out.println("Active links size is :- "+actLink.size());
			
			for(int i=0;i<actLink.size();i++)
			{
				HttpURLConnection connection=(HttpURLConnection)new URL(actLink.get(i).getAttribute("href")).openConnection();
				connection.connect();
				String responce=connection.getResponseMessage();
				connection.disconnect();
				System.out.println(actLink.get(i).getAttribute("href")+"---->"+responce);
			}
		}
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.quit();
		}
}
