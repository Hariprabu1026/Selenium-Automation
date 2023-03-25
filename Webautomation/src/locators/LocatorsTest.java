package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class LocatorsTest {
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "D:\\Automation\\edge\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Hariprabu");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		
//		  String incorrectLoginMessage =
//		  driver.findElement(By.cssSelector("p.error")).getText();
//		  System.out.println(incorrectLoginMessage);
//		  
//		  Assert.assertEquals("* Incorrect username or password",
//		  incorrectLoginMessage);
//		  
//		  driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
//		  Thread.sleep(2000);
//		  
//		  driver.findElement(By.id("inputUsername")).sendKeys("Hariprabu");
//		  driver.findElement(By.name("inputPassword")).sendKeys(password);
		 		
		//Logging in 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println("Login Successful");
		String successfulLoginMsg = driver.findElement(By.xpath("//*[text()='You are successfully logged in.']")).getText();
		Assert.assertEquals("You are successfully logged in.", successfulLoginMsg);
		System.out.println("Validated Homepage message after Login - Passed");
//		driver.manage().deleteAllCookies();
		driver.quit();
		
	}
	//get Password method
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		Thread.sleep(1000);
		String tempPassword = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(tempPassword);

		String[] passwordArray = tempPassword.split("'");
		String password = passwordArray[1].split("'")[0];
		System.out.println("Password is : "+password);
		return password;
	}

}
