package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkBoxAssignment {
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Assert.assertFalse(	driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(	driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(	driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		
		
		driver.quit();
	}

}
