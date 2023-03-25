package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow_NavigateTo {
	public static void main (String args[])
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 //By default the browser will take a pause till the page is fully loaded 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
		 //Browser will not take a pause 
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().forward();
		
		
	}

}
