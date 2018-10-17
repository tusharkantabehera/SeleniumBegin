package FailedTestScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

public class Base {
	
	public static WebDriver driver;
	
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://gmail.com");
		
	}
	
	public static void takeScreenshot(ITestResult r)
	{
		
		String failedTestNAme = r.getName();
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshots\\"+failedTestNAme+timestamp()+"_failed.png");
		System.out.println("Screenshot taken");
		try
		{
			FileHandler.copy(scr, dst);
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	 public static String timestamp() {
	        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	    }
	 
	 public static void onTestSuccess(ITestResult r) {
		 
			String passedTestNAme = r.getMethod().getMethodName();
			EventFiringWebDriver d = new EventFiringWebDriver(driver);
			File src = d.getScreenshotAs(OutputType.FILE);
			File dst = new File("./screenshot/"+passedTestNAme+timestamp()+"_Passed.png");
			try {
				FileHandler.copy(src, dst);
			} catch (IOException e) {
		
			}
			
			
		}
}
