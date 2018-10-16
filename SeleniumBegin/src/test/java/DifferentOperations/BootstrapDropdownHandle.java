package DifferentOperations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapDropdownHandle {

    public WebDriver driver;

	@BeforeMethod
	public void openUrl()
	{
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void selectDropdown_1()
	{
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]/li/a/label"));
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
			if(lst.get(i).getText().contains("Angular"))
			{
				lst.get(i).click();
				break;
			}
		}
	}
	
	@Test
	public void selectDropdown_2()
	{
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		driver.findElement(By.id("dropdownMenuButton")).click();
		List<WebElement> lst=driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
			if(lst.get(i).getText().contains("Action"))
			{
				lst.get(i).click();
				break;
			}
		}
	}
	
	@Test
	public void closeBrowser()
	{
		driver.quit();
	}
}
