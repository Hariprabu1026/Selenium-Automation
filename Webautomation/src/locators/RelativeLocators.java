package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
	@Test
	public void filter()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Relative Locator
		
		WebElement emailEditBox = driver.findElement(By.cssSelector("[name='email']"));
		
		String emailName = driver.findElement(with(By.tagName("label")).above(emailEditBox)).getText();
		System.out.println(emailName);
		
		//Below //toRightOf //toLeftOf
		
	}

}
