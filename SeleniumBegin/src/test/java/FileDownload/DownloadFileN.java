package FileDownload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFileN {

	public WebDriver driver;
	File file;

	@BeforeMethod
	public void openUrl() 
	{
		file=new File(UUID.randomUUID().toString());
		file.mkdir();
		
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		Map<String,Object> pref=new HashMap<String,Object>();
		//pref.put("", value)
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("");
	}

	@Test
	public void downloadFile() {
		
		
		
	}
}
