package DataDrivenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTableToExcel {
	public static WebDriver driver;

	@BeforeClass()
	public void openUrl() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(3000);
	}

	@Test()
	public void getTableData() 
	{
		ExcelUtils excel=new ExcelUtils(".\\src\\test\\java\\DataDrivenTest\\WebTableData.xlsx");
		excel.addSheet("TableData");
		
		//*[@id='customers']/tbody/tr[2]/td[1]
		//*[@id='customers']/tbody/tr[3]/td[1]
		//*[@id='customers']/tbody/tr[4]/td[1]
		
		String beforeXpath="//*[@id='customers']/tbody/tr[";
		String afterXpath="]/td[";
		for(int row=2;row<=7;row++)
		{
			for(int col=1;col<=3;col++)
			{
				String data=driver.findElement(By.xpath(beforeXpath+row+afterXpath+col+"]")).getText();
				System.out.println(data);
				excel.setCellData("TableData", col, row, data);
			}
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
