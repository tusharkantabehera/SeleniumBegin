package DifferentOperations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalanderHandling {

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
	public void setCalanderMethod_1() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		String datef="17-December-2019";
		String[] dateArray=datef.split("-");
		String date =dateArray[0];
		String month =dateArray[1];
		String year =dateArray[2];
		
		Select s1=new Select(driver.findElement(By.name("slctYear")));
		s1.selectByVisibleText(year);
		
		Select s2=new Select(driver.findElement(By.name("slctMonth")));
		s2.selectByVisibleText(month);
		
		try {
		driver.findElement(By.xpath("//td[@class='calendarcell' and normalize-space()='"+date+"']")).click();
		}catch(NoSuchElementException e)
		{
			System.out.println("Please enter the correct date");
		}
		
		Thread.sleep(3000);
	}
	
	@Test
	public void setCalanderMethod_2() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		String datef="17-December-2019";
		String[] dateArray=datef.split("-");
		String date =dateArray[0];
		String month =dateArray[1];
		String year =dateArray[2];
		
		Select s1=new Select(driver.findElement(By.name("slctYear")));
		s1.selectByVisibleText(year);
		
		Select s2=new Select(driver.findElement(By.name("slctMonth")));
		s2.selectByVisibleText(month);
		
		// alternative method
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		
		String before_xpath="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath="]/td["; 
		boolean flag=false;
		String dayValue=null;
		
		for(int row=2;row<=6;row++)
		{
			for(int col=1;col<=7;col++)
			{
				try
				{
					dayValue=driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).getText();
				}catch (NoSuchElementException e) 
				{
					System.out.println("Please enter the correct date");
				}
				System.out.println(dayValue);
				if(dayValue.equals(date))
				{
					driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}
		
		Thread.sleep(3000);
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
