package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderHandle {
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		System.out.println("Previous/Old dates: "+driver.findElements(By.cssSelector("span[class='ui-state-default']")).size());
		List <WebElement> oldDates = driver.findElements(By.cssSelector("span[class='ui-state-default']"));
		
		for(WebElement oldDate : oldDates)
		{
			System.out.println(oldDate.getText());
		}
		
		System.out.println("Current Date: "+driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight']")).getText());
		
	}

}
