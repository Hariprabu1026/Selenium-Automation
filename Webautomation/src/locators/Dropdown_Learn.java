package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdown_Learn {
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		WebElement staticCurrencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		
		Select dropDown = new Select(staticCurrencyDropdown);
		dropDown.selectByIndex(3);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByVisibleText("AED");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByValue("INR");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		//Perform multiple click event with WHILE loop
//		int i=1;
//		while(i<4)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}
		//Perform multiple click event with For loop
		for (int i=1; i<4 ; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		}
		

		String adultCount = driver.findElement(By.id("spanAudlt")).getText();
		System.out.println("Adult Count"+ adultCount);
		Assert.assertEquals(adultCount, "4");
		
		String passengerCount = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(passengerCount);
		Assert.assertEquals(passengerCount, "4 Adult");
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		driver.quit();
	}
}
