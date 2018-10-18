package Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FluentWaitTest {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test
	public void testWait() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/guru99home/");

		driver.manage().window().maximize();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver)
			{
				WebElement element = driver.findElement(By.xpath(
						"/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
				return element;
			}
		};

		WebElement clickseleniumlink = wait.until(function);

		clickseleniumlink.click();

		driver.close();

	}
}

/*
 * 
 * 
 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
 * 
 * .withTimeout(60, SECONDS)
 * 
 * .pollingEvery(2, SECONDS)
 * 
 * .ignoring(NoSuchElementException.class);
 * 
 * 
 * 
 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
 * 
 * public WebElement apply(WebDriver driver) {
 * 
 * return driver.findElement(By.id("foo"));
 * 
 * } });
 * 
 * 
 */