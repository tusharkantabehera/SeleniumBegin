package SikuliForFlashObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlashObjectHandle {
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
		
	}
	
	@Test
	public void youtubeFlashObject() throws FindFailed
	{
		driver.get("https://youtu.be/OtQAMoXYqes");

		Screen s=new Screen();
		Pattern pauseImg=new Pattern(".\\SeleniumBegin\\src\\test\\java\\SikuliForFlashObject\\images\\pauseButton.png");
		s.wait(pauseImg,2000);
		s.click();
		s.click();
		
		Pattern playImg=new Pattern(".\\SeleniumBegin\\src\\test\\java\\SikuliForFlashObject\\images\\playButton.png");
		s.wait(playImg,2000);
		s.click();
		s.click();
		
		Pattern settingImg=new Pattern(".\\SeleniumBegin\\src\\test\\java\\SikuliForFlashObject\\images\\settingButton.png");
		s.wait(settingImg,2000);
		s.click();
		s.click();
		
		Pattern AutoImage=new Pattern(".\\SeleniumBegin\\src\\test\\java\\SikuliForFlashObject\\images\\quality.png");
		s.wait(AutoImage,2000);
		s.click();
		s.click();
		
		Pattern pImg=new Pattern(".\\SeleniumBegin\\src\\test\\java\\SikuliForFlashObject\\images\\480p.png");
		s.wait(pImg,2000);
		s.click();
		s.click();
	}
}


//Sikuli 1.1.2 is not compatable with java 10