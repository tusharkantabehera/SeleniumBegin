package DataDrivenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadTest {
	
	    public static WebDriver driver;
		
		@BeforeClass(enabled=true)
		public void openUrl() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://www.freecrm.com");
			Thread.sleep(3000);
		}
		
		@Test()
		public void signupTest() 
		{
			ExcelUtils excel=new ExcelUtils(".\\src\\test\\java\\DataDrivenTest\\TestData.xlsx");
			String firstname=excel.getCellData("crmtest", "firstname", 2);
			String lastname=excel.getCellData("crmtest", "lastname", 2);
			String email=excel.getCellData("crmtest", "email", 2);
			String username=excel.getCellData("crmtest", "username", 2);
			String password=excel.getCellData("crmtest", "password", 2);
			
			driver.findElement(By.linkText("Sign Up")).click();
			WebElement dropdown=driver.findElement(By.name("payment_plan_id"));
			Select select=new Select(dropdown);
			select.selectByValue("1");
			driver.findElement(By.name("first_name")).sendKeys(firstname);
			driver.findElement(By.name("surname")).sendKeys(lastname);
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("email_confirm")).sendKeys(email);
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("passwordconfirm")).sendKeys(password);
			driver.findElement(By.name("agreeTerms")).click();
			
		}
		
		@AfterClass(enabled=false)
		public void closeBrowser()
		{
			driver.quit();
		}
}
