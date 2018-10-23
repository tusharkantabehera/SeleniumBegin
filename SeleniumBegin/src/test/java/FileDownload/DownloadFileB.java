package FileDownload;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class DownloadFileB {
	
	WebDriver driver;
  @Test
  public void downloadTest() throws InterruptedException 
  {
	  System.setProperty("webdriver.firefox.marionette", ".\\src\\main\\resources\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get("https://filehippo.com/download_firefox/");
	  driver.findElement(By.xpath("//span[text()='Download Latest Version']")).click();
	  Thread.sleep(30000);
	  verifyDownload();
  }
  
  
  public static FirefoxProfile download()
  {
  	FirefoxProfile profile=new FirefoxProfile();
  	
  	//Setting the download path.
  	profile.setPreference("browser.download.dir", "D:\\Downloads");
  	/*Setting the download preference 
  	 * 0 for desktop,
  	 * 1 for download folder
  	 * 2 for specified location
  	*/
  	profile.setPreference("browser.download.folderList", 2);
  	//Setting the file-type
  	profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
  			"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"
  			+"application/pdf;"
  			+"application/vnd.openxmlformats-officedocument.wordprocessingml.document;"
  			+"text/plain;"
  			+"text/csv;"
  			+"application/zip;"
  			+"application/x-msdownload;"
  			+"application/x-rar-compressed;");
  	//setting to download window will not show
  	profile.setPreference("browser.download.manager.showWhenStarting", false);
  	//setting to download pdf instread of opening
  	profile.setPreference("pdfjs.disabled", true);
  	
  	return profile;
  	
  }
  public static void verifyDownload() throws InterruptedException
  {
  	File file=new File("D:\\Downloads\\Firefox Setup 58.0.2.exe");
  	
  	if(file.exists())
  	{
  		System.out.println("File downloading started");
  	}
  	else
  	{
  		System.out.println("Filed not downloaded");
  		System.out.println("Test Failed");
  	}
  	File file1=new File("D:\\Downloads\\Firefox Setup 58.0.2.exe");
  	long size;
  	do
  	{	
  		size=file1.length();
  		System.out.println("File downloading in process....");
  		Thread.sleep(5000);
  		
  	}while(size==0);
  	
  	if(file.exists() && size>0)
  	{
  		System.out.println("Test Passed");
  	}
  	else
  	{
  		System.out.println("Test Failed");
  	}
  }
}
