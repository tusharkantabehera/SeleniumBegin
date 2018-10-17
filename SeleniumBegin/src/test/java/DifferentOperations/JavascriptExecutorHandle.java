package DifferentOperations;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptExecutorHandle {      
	
	    public static WebDriver driver;
		public static int i;
		
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
		
		@Test(priority=1)
		public void highlightLoginButton() throws InterruptedException
		{
			WebElement element=driver.findElement(By.xpath("//input[@type='submit']"));
			flash(driver, element);
		}
		
		@Test(priority=2)
		public void drawBorderLoginButton() throws InterruptedException
		{
			WebElement element=driver.findElement(By.xpath("//input[@type='submit']"));
			drawBorder(driver, element);
			Thread.sleep(5000);
			takeScreenshot();
		}
		
		@Test(priority=3)
		public void scroolIntoForgotPassword() throws InterruptedException
		{
			WebElement element=driver.findElement(By.linkText("Forgot Password?"));
			scroolIntoView(driver, element);
			Thread.sleep(3000);
		}
		
		@Test(priority=4)
		public void Login()
		{
			driver.findElement(By.name("username")).sendKeys("tusharkec143");
			driver.findElement(By.name("password")).sendKeys("lenovopc@12");
			WebElement element=driver.findElement(By.xpath("//input[@type='submit']"));
			clickByJS(driver, element);
			takeScreenshot();
		}
		
		@Test(priority=5)
		public void refresh()
		{
			refreshJS(driver);
		}
		
		@Test(priority=6)
		public void getTitle()
		{
			System.out.println(getTitleByJS(driver));
		}
		
		@Test(priority=7)
		public void printInnerText()
		{
			System.out.println(getPageInnerTextByJS(driver));
		}
		
		@Test(priority=8)
		public void scroll() 
		{
			scrollPageDownByJS(driver);
			takeScreenshot();
		}
		@Test(priority=9)
		public void displayAlert() throws InterruptedException
		{
			generateAlert(driver, "There is an issue");
			Thread.sleep(3000);
		}
		
		@AfterTest
		public void quitBrowser()
		{
			driver.quit();
		}
		
		
		
		
		
		//For highlighting a particular element with JavascriptExecutor
		public static void flash(WebDriver driver,WebElement element) throws InterruptedException
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String bgColor=element.getCssValue("backgroundColor");
			String colour="rgb(0,200,0)";
			for(int i=0;i<100;i++)
			{
				js.executeScript("arguments[0].style.backgroundColor = '"+colour+"'", element);
				Thread.sleep(30);
				js.executeScript("arguments[0].style.backgroundColor = '"+bgColor+"'", element);
				Thread.sleep(30);
			}

		}
		
		//For draw a border with JavascriptExecutor
		public static void drawBorder(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border= '3px solid red'", element);
			
		}
		
		//For generate alert pop-up with JavascriptExecutor
		public static void generateAlert(WebDriver driver,String msg)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("alert('"+msg+"')");
		}
		
		//For click an element with JavascriptExecutor
		public static void clickByJS(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		}
		
		//For refresh the page with JavascriprExecutor
		public static void refreshJS(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("history.go(0)");
		}
		
		//For get the tite of the page with JavascriprExecutor
		public static String getTitleByJS(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String title=js.executeScript("return document.title;").toString();
			return title;
		}
		
		//For get inner text of the page with JavascriprExecutor
		public static String getPageInnerTextByJS(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String innerText=js.executeScript("return document.documentElement.innerText;").toString();
			return innerText;
		}
		
		//For scroll down the page with JavascriprExecutor
		public static void scrollPageDownByJS(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		
		//For scroll the page to the perticular element with JavascriprExecutor
		public static void scroolIntoView(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		public static void scroll(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("scroll(0,400)");
		}
		
		public static void scrollPageUpByJS(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		}
		
		//For taking screenshot
		public static void takeScreenshot()
		{
			File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dst = new File(".\\screenshots\\LoginButton"+i+++".png");
			System.out.println("Screenshot taken");
			try
			{
				FileHandler.copy(scr, dst);
				
			}catch (IOException e) {
				
				e.printStackTrace();
			}

		}

}

        //JavascriptExecuter is an interface implemented by all browser clesses
