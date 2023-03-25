package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	public static void main (String args[]) {
	System.setProperty("webdriver.chrome.driver",
			"D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://www.amazon.com/");
	WebElement move = driver.findElement(By.id("nav-link-accountList"));
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	
	a.moveToElement(move).contextClick().build().perform();
	
	
	
	
	
	}
}
