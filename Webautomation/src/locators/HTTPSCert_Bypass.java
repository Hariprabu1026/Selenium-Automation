package locators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class HTTPSCert_Bypass {
	public static void main(String args[]) {
System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
		options.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		
		//driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		
		String actualTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		String expectedTitle = "expired.badssl.com";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}

}
