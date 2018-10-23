package FileDownload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileN {

	public WebDriver driver;
	File folder;

	@BeforeMethod
	public void setBrowser() 
	{
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		Map<String,Object> pref=new HashMap<String,Object>();
		pref.put("profile.default_content_settings.popups", 0);
		pref.put("download.default_directory",folder.getAbsolutePath());
		options.setExperimentalOption("prefs", pref);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(cap);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void downloadFile() throws InterruptedException 
	{
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(5000);
		
		File listOfFile[] =folder.listFiles();
		Assert.assertTrue(listOfFile.length > 0);
		
		for(File file : listOfFile)
		{
			Assert.assertTrue(file.length() > 0);
		}
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}
}
