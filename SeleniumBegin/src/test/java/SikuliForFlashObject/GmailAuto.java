package SikuliForFlashObject;

import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailAuto {

	public static WebDriver driver;

	@BeforeClass
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/gmail/");
	}

	@Test(priority = 1)
	public void login() throws InterruptedException, FindFailed {
		Screen screen = new Screen();
		Pattern userName = new Pattern("give image path");
		Pattern password = new Pattern("give image path");
		Pattern nextButton = new Pattern("give image path");
		screen.type(userName, "tushartesting1@gmail.com");
		screen.click(nextButton);
		Thread.sleep(2000);
		screen.type(password, "lenovopc@12");
		screen.click(nextButton);
	}

	@Test(priority = 2, enabled = true)
	public void deleteMsg() throws InterruptedException {

		java.util.List<WebElement> lst = driver.findElements(By.xpath(
				"//td[contains(@class,'yX xY')]/div[1]/span[@class='yP']/../../preceding-sibling::td[2]/div/div"));
		System.out.println(lst.size());
		ListIterator<WebElement> itr = lst.listIterator();
		while (itr.hasNext()) {
			itr.next().click();
		}
	}

	@Test(priority = 3, enabled = true)
	public void Logout() {
		driver.findElement(By.xpath("//span[@class='gb_ab gbii']")).click();
		driver.findElement(By.xpath("//a[@id='gb_71' or text()='Sign out']")).click();
	}
}
