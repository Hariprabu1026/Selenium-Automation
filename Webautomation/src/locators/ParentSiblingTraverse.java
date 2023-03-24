package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentSiblingTraverse {
	public static void main (String args[])
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Sibling to Sibling traverse 
		String loginText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(loginText);
		
		//child to parent xpath traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button/parent::div/button[3]")).getText());
		
		
		driver.quit();
	
	}

}
