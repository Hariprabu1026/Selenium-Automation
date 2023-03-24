package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTable {
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
																							
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> webTable = driver.findElements(By.xpath("//fieldset/table/tbody/tr"));
		
		for(WebElement webTables : webTable)
		{
			System.out.println(webTables.getText());
			if(webTables.getText().equalsIgnoreCase("Rahul Shetty Master Selenium Automation in simple Python Language 25"))
			{
				System.out.println("Selenium Course Available");
				break;
			}
			
		}
		
		driver.quit();
		
	}

}
